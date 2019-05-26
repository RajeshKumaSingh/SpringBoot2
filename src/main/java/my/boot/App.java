package my.boot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, 
		JpaRepositoriesAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
/*
 @SpringBootApplication replaces:
 1. @SpringBootConfiguration or @Configuration
 
 2. @EnableAutoConfiguration
 
 This annotation is used to enable auto-configuration of the Spring Application Context, 
 attempting to guess and configure beans that you are likely to need. 
 Auto-configuration classes are usually applied based on your classpath and what beans 
 you have defined.
 Auto-configuration tries to be as intelligent as possible and will back-away as you 
 define more of your own configuration. You can always manually exclude any configuration 
 that you never want to apply using two methods –

	i) Use excludeName()
	ii) Using the spring.autoconfigure.exclude property in properties file. e.g.
 @EnableAutoConfiguration(excludeName = {"multipartResolver","mbeanServer"})

 Auto-configuration is always applied after user-defined beans have been registered.

 3. @ComponentScans
 
 */
public class App {

	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(App.class, args);
		
		/*String[] beanNames = ctx.getBeanDefinitionNames();
		
		Arrays.sort(beanNames);
		
		for(String s : beanNames) {
			System.out.println(s);
		}*/
		List<ErrorResponse> elist = new ArrayList<>();
		elist.add(new ErrorResponse("test1 ", new ArrayList<String>()));
		elist.add(new ErrorResponse("test2 ", new ArrayList<String>()));
		elist.add(new ErrorResponse("test3 ", new ArrayList<String>()));
		System.out.println(elist);
		ErrorResponseSorting es= ctx.getBean(ErrorResponseSorting.class);
		es.sortErrorResponse(elist);
		System.out.println("After sorting:\n"+elist);
	}
}
