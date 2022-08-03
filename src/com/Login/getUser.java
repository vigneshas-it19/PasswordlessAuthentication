package com.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;

public class getUser extends ActionSupport {
	private String emailid;
	private String userDetailsJson;
	
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getUserDetailsJson() {
		return userDetailsJson;
	}
	public void setUserDetailsJson(String userDetailsJson) {
		this.userDetailsJson = userDetailsJson;
	}
	
	
	public String getUserDetails()
	{
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/password_less_auth","root",""); 
			Statement st = con.createStatement();
			String query = "select * from users where email = '"+emailid+"'";
			ResultSet rs = st.executeQuery(query);
			
			JSONArray array = new JSONArray();
			while(rs.next())
			{
				JSONObject obj = new JSONObject();
				obj.put("name", rs.getString(1));
				obj.put("email", rs.getString(2));
				obj.put("location", rs.getString(3));
				obj.put("phone", rs.getString(4));
				array.put(obj);
			}
			setUserDetailsJson(array.toString());     
		}catch(Exception e){e.printStackTrace();} 
      
        return SUCCESS;
    }
}
