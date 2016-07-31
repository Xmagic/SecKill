package org.seckill.service.impl;

import java.util.Date;
import java.util.List;

import org.seckill.dao.SeckillDao;
import org.seckill.dao.SuccessKilledDao;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.SecKill;
import org.seckill.entity.SuccessKilled;
import org.seckill.enums.SeckillStateEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

@Service
public class SeckillServiceImpl implements SeckillService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	//mybatis auto inject
	@Autowired
	private SeckillDao seckillDao;

	//mybatis auto inject
	@Autowired
	private SuccessKilledDao successKilledDao;

	private static final String md5Slat = "689789dsahKHDSAT&*Y*(";

	@Override
	public List<SecKill> getSeckillList() {
		// TODO Auto-generated method stub
		return seckillDao.queryAll(0, 4);
	}

	@Override
	public SecKill getById(long seckillId) {
		// TODO Auto-generated method stub
		return seckillDao.queryById(seckillId);
	}

	@Override
	public Exposer exportSeckillUrl(long seckillId) {
		// TODO Auto-generated method stub
		SecKill seckill = seckillDao.queryById(seckillId);
		if (seckill == null) {
			return new Exposer(false, seckillId);
		}
		Date startTime = seckill.getStartTime();
		Date endTime = seckill.getEndTime();
		Date now = new Date();
//		if (now.getTime() < startTime.getTime() || now.getTime() > endTime.getTime()) {
//			return new Exposer(false, seckillId, now.getTime(), startTime.getTime(), endTime.getTime());
//		}
		String md5 = getMd5(seckillId);
		return new Exposer(true, md5, seckillId);
	}

	private String getMd5(long seckillId) {
		String base = seckillId + "/" + md5Slat;
		String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
		return md5;
	}

	@Override
	@Transactional
	public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
			throws SeckillException, RepeatKillException, SeckillCloseException {
		if (md5 == null || !md5.equals(getMd5(seckillId))) {
			throw new SeckillException("Seckill data rewrite");
		}
		try {

			Date nowTime = new Date();
			int updateCount = seckillDao.reduceNumber(seckillId, nowTime);

			if (updateCount <= 0) {
				// no update
				throw new SeckillCloseException("Seckill is closed");
			} else {
				// Record the purchase
				int insertCount = successKilledDao.insertSuccessKilled(seckillId, userPhone);
				if (insertCount <= 0) {
					throw new RepeatKillException("Repeat kill");
				} else {
					SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
					return new SeckillExecution(seckillId, SeckillStateEnum.SUCCESS, successKilled);
				}
			}
		}
		catch (SeckillCloseException e1) {
			throw e1;
		}
		catch (RepeatKillException e2) {
			throw e2;
		}
		catch (Exception e) {
			logger.error(e.getMessage());
			throw new SeckillException("Seckill inner errors: " + e.getMessage(),e.getCause());
		}
	}
}
