package my.boot.config.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class BootInterceptor implements HandlerInterceptor {
	
	private static Logger logger = LoggerFactory.getLogger(BootInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("\n---PRE-HANDLE--\n"+request.getAuthType()+"\n---------------------\n");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("\n---POST-HANDLE--\n"+response.toString()+"\n---------------------\n");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("\n---AFTER-COMPLETION--\n"+response.toString()+"\n---------------------\n");
	}

}
