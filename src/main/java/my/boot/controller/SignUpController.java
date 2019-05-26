package my.boot.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import my.boot.form.SignUpForm;
import my.boot.service.SignupService;

@Controller
public class SignUpController {

	private static final Logger logger = LoggerFactory.getLogger(SignUpController.class);
	
	@Autowired
	SignupService signupService;
	
	@PostMapping("/validateSignUp")
	@ResponseBody
	public List<String> validateSignUp(@Valid @ModelAttribute("signUpForm") SignUpForm signUpForm, BindingResult result
			,  RedirectAttributes redirectAttributes) {
		List<String> objectErrorList = new ArrayList<String>();
		if(result.hasErrors()) {
			
			logger.error("Error in form");
			for(FieldError err:result.getFieldErrors()) {
				logger.error(err.getField());
				logger.error(err.getDefaultMessage());
				objectErrorList.add(err.getDefaultMessage());
			}
			
			for(ObjectError err:result.getAllErrors()) {
				if(!(err instanceof FieldError )) {
					objectErrorList.add(err.getDefaultMessage());
				}
			}
		}
		String email = signUpForm.getEmail();
		if(signupService.checkExistingEmail(email)) {
			objectErrorList.add("Email already in use");
		}
		if(!objectErrorList.isEmpty()) {
			return objectErrorList;
		}else {
			return Arrays.asList("success");
		}
		
	}
	
	@PostMapping("/signUp")
	public String signUp(@Valid @ModelAttribute("signUpForm") SignUpForm signUpForm, BindingResult result
			,  RedirectAttributes redirectAttributes, HttpSession session) {
		if(result.hasErrors()) {
			logger.error("Error in form");
			for(FieldError err:result.getFieldErrors()) {
				logger.error(err.getField());
				logger.error(err.getDefaultMessage());
				redirectAttributes.addFlashAttribute(err.getField()+"_error", err.getDefaultMessage());
			}
			List<String> objectErrorList = null;
			for(ObjectError err:result.getAllErrors()) {
				if(!(err instanceof FieldError )) {
					if(objectErrorList == null) {
						objectErrorList = new ArrayList<String>();
					}
					objectErrorList.add(err.getDefaultMessage());
				}
			}
			if(objectErrorList!=null) {
				redirectAttributes.addFlashAttribute("objectErrorList", objectErrorList);
			}
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginForm", result);
	        redirectAttributes.addFlashAttribute("signUpForm", signUpForm);
			return "redirect:home";
		}else {
			signupService.save(signUpForm);
			session.setAttribute("user", signUpForm.getUserName());
		}
		return "redirect:home";
		
	}

}
