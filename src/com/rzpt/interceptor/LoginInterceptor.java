package com.rzpt.interceptor;

import java.util.Map;

import javax.servlet.ServletContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("LoginInterceptor执行了");
		ActionContext.getContext().getSession();
		if (ActionContext.getContext().getSession().get("loginInfo") != null) {
			String result = invocation.invoke();
			System.out.println("invocation.invoke()="+result);
			return result;
		}
		ActionContext.getContext().getSession().put("logingerror", "登录身份已过期，请点右上角退出按钮重新登录！");
		return "error";
	}
}
