package my.boot.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import my.boot.form.LoginForm;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@PostMapping("/validateLoginForm")
	@ResponseBody
	public List<String> validateSignUp(@Valid @ModelAttribute("loginForm") LoginForm loginForm, BindingResult result
			,  RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			List<String> objectErrorList = new ArrayList<String>();
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
			if(objectErrorList!=null) {
				return objectErrorList;
			}
		}
		return Arrays.asList("success");
		
	}
	
	@PostMapping("/login")
	public String signUp(@Valid @ModelAttribute("loginForm") LoginForm loginForm, BindingResult result
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
	        redirectAttributes.addFlashAttribute("loginForm", loginForm);
			return "redirect:home";
		}else {
			session.setAttribute("user", loginForm.getEmail());
		}
		return "home";
		
	}
	
	@PostMapping("/logout")
	public String logout( HttpSession session) {
		session.setAttribute("user", null);
		return "redirect:home";
		
	}

}
