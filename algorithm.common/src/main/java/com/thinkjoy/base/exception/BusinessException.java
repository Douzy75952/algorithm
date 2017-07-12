package com.thinkjoy.base.exception;

public class BusinessException extends RuntimeException
{
	private static final long serialVersionUID = 7395950234322084363L;

	private String code;
	
	private Object data;

	public BusinessException()
	{
		super();
	}

	public BusinessException(String code)
	{
		this.code = code;
	}
	
	public BusinessException(String code, String message)
	{
		super(message);
		this.code=code;
	}

	public BusinessException(String code, String message, Throwable cause)
	{
		super(message, cause);
		this.code = code;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public Object getData()
	{
		return data;
	}

	public BusinessException setData(Object data)
	{
		this.data = data;
		return this;
	}
}
