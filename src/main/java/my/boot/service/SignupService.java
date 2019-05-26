package my.boot.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.boot.dao.UserDetailsDAO;
import my.boot.form.SignUpForm;
import my.boot.model.UserDetails;

@Service
public class SignupService {
	
	@Autowired
	UserDetailsDAO userDetailsDAO; 

	public boolean checkExistingEmail(String email) {
		return userDetailsDAO.checkExistingEmail(email);
	}

	public void save(@Valid SignUpForm signUpForm) {
		UserDetails userDetial = new UserDetails();
		userDetial.setEmail(signUpForm.getEmail());
		userDetial.setPassword(signUpForm.getPassword());
		userDetial.setUserName(signUpForm.getUserName());
		userDetailsDAO.save(userDetial);
		
	}

}
