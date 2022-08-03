package com.Registration;

import java.sql.*;

import org.json.JSONArray;
import org.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;

public class Register extends ActionSupport{
	private String name, email, location;
	private long phone;
	private String RegistrationSuccessJson;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getRegistrationSuccessJson() {
		return RegistrationSuccessJson;
	}
	public void setRegistrationSuccessJson(String registrationSuccessJson) {
		RegistrationSuccessJson = registrationSuccessJson;
	}
	
	
	public String execute()
	{
		int status=0;  
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/password_less_auth","root","");  
		  
		PreparedStatement ps=con.prepareStatement("insert into users(email,name,phone,location) values(?,?,?,?)");  
		ps.setString(1,email);  
		ps.setString(2,name);  
		ps.setLong(3,phone);  
		ps.setString(4,location);  
		          
		status=ps.executeUpdate();  
		  
		}catch(Exception e){e.printStackTrace();} 
		JSONArray array = new JSONArray();
		JSONObject obj = new JSONObject();
		 if(status>0){
			 obj.put("status", "successfully registered");
			 array.put(obj);
			 RegistrationSuccessJson = array.toString();     
			 return "success";  
		}  
		 obj.put("status", "some error occured");
		 array.put(obj);
		 RegistrationSuccessJson = array.toString();   
		return "error";    
	}
	
	
	
	
}
