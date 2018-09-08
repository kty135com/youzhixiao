package com.rzpt.util;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ErrorProcess extends ActionSupport {
	private Exception exception;

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

	@Override
	public String execute() {
		ActionContext.getContext().getValueStack().push(this.exception.getMessage());// ·Åµ½ÖµÕ»¶¥
		exception.printStackTrace();
		return this.SUCCESS;
	}
}
