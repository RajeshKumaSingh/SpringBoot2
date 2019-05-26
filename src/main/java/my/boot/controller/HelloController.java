package my.boot.controller;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import my.boot.form.LoginForm;
import my.boot.model.NewProduct;

@Controller
@RequestMapping({"/","home"})
@Transactional
public class HelloController {

	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	@GetMapping("/hello")
	public String sayHello(ModelMap model) {
		Session session = sessionFactory.getCurrentSession();
		NewProduct np = session.find(NewProduct.class, "Red");
		logger.info("New product is: "+np.getQuantity());
		model.put("color", np.getColor());
		return "hello";
	}
	
	@GetMapping
	public String getHome(ModelMap model) {
		return "home";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		if(!model.containsAttribute("loginForm")) {
			model.addAttribute("loginForm", new LoginForm());
		}
		return "login";
		
	}
	
	/*@PostMapping("/login")
	public String checklogin(@Valid @ModelAttribute("loginForm") LoginForm loginForm, BindingResult result
			,  RedirectAttributes redirectAttributes) {
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
			return "redirect:login";
		}
		return "home";
		
	}*/
}
