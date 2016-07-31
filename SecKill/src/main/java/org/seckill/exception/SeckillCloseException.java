package org.seckill.exception;

/**
 * Spring can only catch Runtime exception for us, so this exception must extends from RuntiemException
 * @author gaojun
 *
 */
public class SeckillCloseException extends SeckillException {

	public SeckillCloseException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public SeckillCloseException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
