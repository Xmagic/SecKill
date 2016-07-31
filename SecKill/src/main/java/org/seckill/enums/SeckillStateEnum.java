package org.seckill.enums;

public enum SeckillStateEnum {
	
	SUCCESS(1,"Success killed"),
	END(0, "Seckill ended"),
	REPEAT(-1, "Repeat Kill"),
	INNER_ERROR(-2, "System Error"),
	DATA_REWRITE(-3, "Data write");
	
	
	private int state;
	
	private String stateInfo;

	private SeckillStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}
	
	public static  SeckillStateEnum stateOf(int index) {
		for(SeckillStateEnum stateEnum : values()) {
			if(stateEnum.getState()== index)
				return stateEnum;
		}
		return null;
	}
	
	
}
