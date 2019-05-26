package my.boot.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import my.boot.validator.ValidPassword;

@ValidPassword(message="{validation.message.passwordMismatch}")
public class SignUpForm {
	
	/*
	 * validation.message.passwordEmpty=Provide password
validation.message.retypePasswordEmpty=Re-type password
validation.message.passwordMismatch=Password mismatch
	 * 
	 */
	
	@NotEmpty(message="Provide User Name")
	private String userName;
	
	@Email(message="Invalid E-mail id")
	@NotEmpty(message="Provide E-mail id")
	private String email;
	
	@NotEmpty(message="{validation.message.passwordEmpty}")
	private String password;
	
	@NotEmpty(message="{validation.message.retypePasswordEmpty}")
	private String retypePassword;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRetypePassword() {
		return retypePassword;
	}
	public void setRetypePassword(String retypePassword) {
		this.retypePassword = retypePassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
