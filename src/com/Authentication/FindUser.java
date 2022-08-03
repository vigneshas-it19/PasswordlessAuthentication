package com.Authentication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;

public class FindUser extends ActionSupport{
	private String email;
	private String noOfRecordsJson;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNoOfRecordsJson() {
		return noOfRecordsJson;
	}
	public void setNoOfRecordsJson(String noOfRecordsJson) {
		this.noOfRecordsJson = noOfRecordsJson;
	}
	public String execute() {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/password_less_auth","root",""); 
			Statement st = con.createStatement();
			String query = "select * from users where email = '"+email+"'";
			ResultSet rs = st.executeQuery(query);
			
			JSONArray array = new JSONArray();
			JSONObject obj = new JSONObject();
			if(rs.next())
			{
				 obj.put("status", "user found");
				 array.put(obj);
				 noOfRecordsJson = array.toString();     
				 return "success";  
			}
			obj.put("status", "no user found");
			array.put(obj);
			noOfRecordsJson = array.toString();     
			return "success";  		
		  
		}catch(Exception e){e.printStackTrace();} 
      
        return SUCCESS;
	}
}
