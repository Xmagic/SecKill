package org.seckill.dao;

import org.seckill.entity.SuccessKilled;

public interface SuccessKilledDao {
	
	/**
	 * Insert purchase details, can filter duplicate
	 * @param seckillId
	 * @param userPhone
	 * @return inserted row number
	 */
	int insertSuccessKilled(long seckillId,long userPhone);
	
	
	/**
	 * Query SuccessKilled Item by id, and return the SuccessKilled object
	 * @param seckillId
	 * @return
	 */
	SuccessKilled queryByIdWithSeckill(long seckillId);
}
