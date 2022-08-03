package com.Authentication;

import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.json.JSONArray;
import org.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;


public class OTPGeneration extends ActionSupport implements SessionAware{
	
	private String emailid;
	private SessionMap<String, Object> sessionOtp;
	private String otpSentJson;
	
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
//	public SessionMap<String, Object> getSessionOtp() {
//		return sessionOtp;
//	}
	public String getOtpSentJson() {
		return otpSentJson;
	}
	public void setOtpSentJson(String otpSentJson) {
		this.otpSentJson = otpSentJson;
	}
	public static int otp()
    {
        int out = (int)(Math.random()*1000000);
        if(String.valueOf(out).length()<6)
        {
            return otp();
        }
        return out;
    }
	public String sendEmail() {
				//Turn on less security off sender
				//https://myaccount.google.com/lesssecureapps
				final String user="vigneshas5697@gmail.com";//change accordingly  
				final String password="mhuxzrtuftfqhubl";//change accordingly  
				//String to="vigneshas.it19@bitsathy.ac.in"; 
				String to=emailid; 
				  

				Properties props = new Properties();    
		        props.put("mail.smtp.host", "smtp.gmail.com"); 
//		        props.put("mail.smtp.socketFactory.port", "465");    
//		        props.put("mail.smtp.socketFactory.class",    
//		                  "javax.net.ssl.SSLSocketFactory");    
//		        props.put("mail.smtp.auth", "true");    
//		        props.put("mail.smtp.port", "465");   
		        props.put("mail.smtp.port", "587");
		        props.put("mail.smtp.auth", "true");
		        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		        props.put("mail.smtp.starttls.enable", "true");
				   
				Session session = Session.getDefaultInstance(props,  
				    new javax.mail.Authenticator() {  
				      protected PasswordAuthentication getPasswordAuthentication() {  
				    return new PasswordAuthentication(user,password);  
				      }  
				});  
				  
				int otpgenerated = otp();
				//Compose the message  
				try {  
				   MimeMessage message = new MimeMessage(session);  
				   message.setFrom(new InternetAddress(user));  
				   message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
				   message.setSubject("PasswordLess Auth OTP");  
				   //message.setText("This is simple program of sending email using JavaMail API");
				   message.setContent("<h2 style=\"text-align: center;\">Your OTP</h2><br>\n" + 
				   		"<center><div id='otp' style=\"text-align: center;\n" + 
				   		"    background-color: rgb(62, 199, 199);\n" + 
				   		"    padding: 10px;\n" + 
				   		"    width: 50%;\n" + 
				   		"    height: fit-content;\n" + 
				   		"    font-size: 250%;\n" + 
				   		"    color: black;\n" + 
				   		"    padding: 3%;\n" + 
				   		"    border-radius: 5vh;\n" + 
				   		"    font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;\n" + 
				   		"    box-shadow: 0 0 10px #303030;\">"+otpgenerated+"</div></center>", "text/html");
				       
				   //send the message  
				   Transport.send(message);  
				   
				   
				   sessionOtp.put("otp", otpgenerated);
				   
				   System.out.println("message sent successfully..."); 
				   JSONArray array = new JSONArray();
				   JSONObject obj = new JSONObject();
				   obj.put("status", "successfully sent otp");
				   array.put(obj);
				   otpSentJson = array.toString(); 
				   return SUCCESS;
				   
				 } catch (MessagingException e) 
					{e.printStackTrace();}  
				return ERROR;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.sessionOtp = (SessionMap<String, Object>) arg0;
	}
}
