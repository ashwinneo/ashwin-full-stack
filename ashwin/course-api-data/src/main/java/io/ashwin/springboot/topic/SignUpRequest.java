package io.ashwin.springboot.topic;

public class SignUpRequest {
	
	String fullName;
	String email;
	String userName;
	String password;
	String RepeatPassword;
	
	public String getRepeatPassword() {
		return RepeatPassword;
	}
	public void setRepeatPassword(String repeatPassword) {
		RepeatPassword = repeatPassword;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
