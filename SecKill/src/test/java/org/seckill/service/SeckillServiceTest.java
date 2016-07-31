package org.seckill.service;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.SecKill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class SeckillServiceTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SeckillService seckillService;

	@Test
	public void testGetSeckillList() throws Exception{
		List<SecKill> list = seckillService.getSeckillList();
		logger.info("List={}", list );
	}

	@Test
	public void testGetById() throws Exception{
		long id = 1000;
		SecKill secKill = seckillService.getById(id);
		logger.info("seckill={}",secKill);
		
	}

	@Test
	public void testExportSeckillUrl() throws Exception{
		long id = 1003;
		Exposer exposer = seckillService.exportSeckillUrl(id);
		logger.info("Exposer={}" ,exposer);
		
//	id1000	exposed=true, md5=1ece9ec3c11eaf4213f2c6f8df2d3ef0, seckillId=1000, now=0, start=0, end=0
		// id1002 md5=834babb6b5aafc607ee94c185a067191
		// id1003=09f4d4cd220597bcd20f1c5ae24d4c9f
	}

	@Test
	public void testExecuteSeckill() throws Exception{
		long id =1003;
		long phone = 33333333333L;
		String md5 = "09f4d4cd220597bcd20f1c5ae24d4c9f";
		try {
		SeckillExecution exec = seckillService.executeSeckill(id, phone, md5);
		logger.info("SeckillExecution={}",exec);
		} catch (RepeatKillException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		catch (SeckillException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}

}
