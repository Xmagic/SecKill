package org.seckill.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SecKill;
import org.seckill.entity.SuccessKilled;

public interface SuccessKilledDao {
	
	/**
	 * Insert purchase details, can filter duplicate
	 * @param seckillId
	 * @param userPhone
	 * @return inserted row number
	 */
	int insertSuccessKilled(@Param(value="seckillId") long seckillId,@Param(value="userPhone") long userPhone);
	
	
	/**
	 * Query SuccessKilled Item by id, and return the SuccessKilled object
	 * @param seckillId
	 * @return
	 */
	SuccessKilled queryByIdWithSeckill(@Param(value="seckillId") long seckillId,@Param(value="userPhone") long userPhone);
	
	/**
	 * Query all SuccessKilled Items
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<SuccessKilled> queryAll(@Param(value="offset")int offset, @Param(value="limit")int limit);
}
