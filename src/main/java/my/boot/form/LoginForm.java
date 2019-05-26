package my.boot.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class LoginForm {
	
	/*
	 * validation.message.passwordEmpty=Provide password
validation.message.retypePasswordEmpty=Re-type password
validation.message.passwordMismatch=Password mismatch
	 * 
	 */
	
	@Email(message="Invalid Email id")
	@NotEmpty(message="Provide Email id")
	private String email;
	
	@NotEmpty(message="Provide password")
	private String password;
	
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
}
