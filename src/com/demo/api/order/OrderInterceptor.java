package com.demo.api.order;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * UserInterceptor
 * 此拦截器仅做为示例展示，在本 demo 中并不需要
 */
public class OrderInterceptor implements Interceptor {
	
	public void intercept(Invocation inv) {
		System.out.println("Before invoking " + inv.getActionKey());
		inv.invoke();
		System.out.println("After invoking " + inv.getActionKey());
	}
}
