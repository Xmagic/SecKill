package org.seckill.dao;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SecKill;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Junit startup will load SpringIOC container
 * @author gaojun
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

	//inject Dao class depdency
	
	@Resource
	private SeckillDao seckillDao;
	
	@Test
	public void testReduceNumber() throws Exception {
		try {
			Date killtime = DateFormat.getDateInstance().parse("2016-11-01 00:01:00");
			int result = seckillDao.reduceNumber(1002L, killtime);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQueryById() throws Exception {
		try {
			long id = 1000;
			SecKill secKill = seckillDao.queryById(id);
			System.out.println(secKill.getName());
			System.out.println(secKill);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQueryAll() throws Exception {
		try {
			List<SecKill> secKillList = seckillDao.queryAll(0, 6);
			for (int i = 0; i < secKillList.size(); i++) {
				System.out.println(secKillList.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
