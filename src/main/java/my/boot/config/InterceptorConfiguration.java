package my.boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import my.boot.config.interceptors.BootInterceptor;

@SuppressWarnings("deprecation")
@Component
public class InterceptorConfiguration extends WebMvcConfigurerAdapter {
	
	@Autowired
	BootInterceptor bootInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(bootInterceptor).addPathPatterns("/interceptor");
	}
}
