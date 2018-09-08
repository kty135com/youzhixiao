package com.rzpt.interceptor;

import java.util.Map;

import javax.servlet.ServletContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("LoginInterceptorִ����");
		ActionContext.getContext().getSession();
		if (ActionContext.getContext().getSession().get("loginInfo") != null) {
			String result = invocation.invoke();
			System.out.println("invocation.invoke()="+result);
			return result;
		}
		ActionContext.getContext().getSession().put("logingerror", "��¼����ѹ��ڣ�������Ͻ��˳���ť���µ�¼��");
		return "error";
	}
}
