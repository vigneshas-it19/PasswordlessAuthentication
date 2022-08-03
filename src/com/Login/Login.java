package com.Login;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.json.JSONArray;
import org.json.JSONObject;

public class Login implements SessionAware {
	private SessionMap<String, Object> session;
	private String emailid;
	private String loginSuccessJson;
	public String getLoginSuccessJson() {
		return loginSuccessJson;
	}
	public void setLoginSuccessJson(String loginSuccessJson) {
		this.loginSuccessJson = loginSuccessJson;
	}
	public SessionMap<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = (SessionMap<String, Object>) session;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getRestricted(){
		  return "success";
	}

	public String addUserToSession() {
		   session.put("user", emailid);
		   JSONArray array = new JSONArray();
		   JSONObject obj = new JSONObject();
		   obj.put("status", "loggedin");
		   array.put(obj);
		   loginSuccessJson = array.toString(); 
		   return "success";
	}
	
	public String logout() {
		  session.invalidate();
		  return "success";
	}

	
}
