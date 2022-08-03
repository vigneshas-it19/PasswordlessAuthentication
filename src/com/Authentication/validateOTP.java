package com.Authentication;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import org.json.JSONArray;
import org.json.JSONObject;

public class validateOTP extends ActionSupport implements SessionAware{

	private String otpValidateJson;
	private String otp;
	public String getOtpValidateJson() {
		return otpValidateJson;
	}
	public void setOtpValidateJson(String otpValidateJson) {
		this.otpValidateJson = otpValidateJson;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	
	
	public String checkOtp() {
        HttpSession session=ServletActionContext.getRequest().getSession(false);  
        if(Integer.parseInt(String.valueOf(session.getAttribute("otp")))==Integer.parseInt(otp)) {
			JSONArray array = new JSONArray();
			JSONObject obj = new JSONObject();
			obj.put("status", "verified");
			array.put(obj);
			otpValidateJson = array.toString(); 
			return SUCCESS;
		}
		JSONArray array = new JSONArray();
		JSONObject obj = new JSONObject();
		obj.put("status", "Invalid OTP");
		array.put(obj);
		otpValidateJson = array.toString(); 
		return SUCCESS;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
}
