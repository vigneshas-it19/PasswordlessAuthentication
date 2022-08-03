package com.Login;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class SessionInterceptor implements Interceptor {

	 @Override
	 public void destroy() {
	  // TODO Auto-generated method stub
	
	 }
	
	 @Override
	 public void init() {
	  // TODO Auto-generated method stub
	
	 }
	
	 @Override
	 public String intercept(ActionInvocation invocation) throws Exception {
	  Map<String, Object> session = invocation.getInvocationContext()
	    .getSession();
	
	  String userName = (String) session.get("user");
	
	  if (userName == null) {
	   return "loginUser";
	  }
	  return invocation.invoke();
	 }

}