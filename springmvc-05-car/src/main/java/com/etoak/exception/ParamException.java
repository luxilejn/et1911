package com.etoak.exception;

/**
 * 自定义异常<BR>
 * 异常类型: <BR>
 * 运行时异常 - 非检查型异常(unchecked exception) <BR>
 * 编译时异常 - 检查型异常(checked exception) <BR>
 */
public class ParamException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ParamException(String message) {
		super(message);
	}

}
