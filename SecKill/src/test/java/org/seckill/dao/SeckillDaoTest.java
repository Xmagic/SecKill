package org.seckill.dao;

import static org.junit.Assert.*;

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
		
	}

}
