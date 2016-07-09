package org.seckill.entity;

import java.sql.Date;

public class SuccessKilled {
	private long seckillId;
	
	private long userPhone;
	
	private short state;
	
	private Date createTime;
	
	// multi to 1
	private SecKill secKill;

	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public long getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}

	public short getState() {
		return state;
	}

	public void setState(short state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "SuccessKilled [seckillId=" + seckillId + ", userPhone=" + userPhone + ", state=" + state
				+ ", createTime=" + createTime + "]";
	}

	public SecKill getSecKill() {
		return secKill;
	}

	public void setSecKill(SecKill secKill) {
		this.secKill = secKill;
	}
}
