package org.seckill.dao;

import java.util.Date;
import java.util.List;

import org.seckill.entity.SecKill;

public interface SeckillDao {

	/**
	 * Reduce the item in the DB
	 * @param seckillId
	 * @param killTime
	 * @return If the affected row >1, its the updated row number.
	 */
	int reduceNumber(long seckillId,Date killTime);
	
	/**
	 * Query item by id
	 * @param seckillId
	 * @return
	 */
	SecKill queryById(long seckillId);
	
	/**
	 * Query the item list by offset.
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<SecKill> queryAll(int offset, int limit);
	
}
