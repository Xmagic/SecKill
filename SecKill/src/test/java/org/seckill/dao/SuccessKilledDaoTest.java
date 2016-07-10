package org.seckill.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml" })
public class SuccessKilledDaoTest {

	@Resource
	SuccessKilledDao successKilledDao;

	/**
	 * 1st insert return 1;
	 * 
	 * 2nd insert return 0 (duplicate insert, ignored);
	 * 
	 * @throws Exception
	 */
	@Test
	public void testInsertSuccessKilled() {
		try {
			long id = 1003L;
			long phone = 13525812363L;
			int result = successKilledDao.insertSuccessKilled(id, phone);

			System.out.println("Insert Result: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Query SuccessKilled Item by id, and return the SuccessKilled object
	 * 
	 * @param seckillId
	 * @return
	 */
	@Test
	public void testQueryByIdWithSeckill() {
		try {

			long successId = 1001L;
			long phone = 13525874563L;
			SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(successId, phone);
			System.out.println(successKilled);
			System.out.println(successKilled.getSecKill());
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	}

	/**
	 * Query all SuccessKilled Items
	 * 
	 * @param seckillId
	 * @return
	 */
	@Test
	public void testQueryAll() {
		try {
			List<SuccessKilled> successKilledItems = successKilledDao.queryAll(0, 100);

			for (int i = 0; i < successKilledItems.size(); i++) {
				SuccessKilled item = successKilledItems.get(i);
				System.out.println(item);
				System.out.println(item.getSecKill());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
