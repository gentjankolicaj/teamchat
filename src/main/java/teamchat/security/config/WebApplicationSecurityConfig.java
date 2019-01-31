package teamchat.security.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebApplicationSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	private static final String[] FREE_URI= {
			
			"/home","/home/**",
			"/about","/about/**",
			"/contact","/contact/**",
			"/signin","/signin/**",	
			"/signout","/signout/**",	
			"/signup","/signup/**",	
			"/api/rest/**"		
			};
	
	private static final String[] SECURED_URI= {
			"/","/**",
	};
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers(FREE_URI).permitAll();
		//http.authorizeRequests().antMatchers(SECURED_URI).denyAll();
	}
	
	
	@Autowired
	private ApplicationContext context;
	
	@PostConstruct
	public void printBeans() {
		String [] beanNames=context.getBeanDefinitionNames();
		System.out.println();
		System.out.println("---------------------------------After Spring Security init --------------------------------");
		for(String name:beanNames) {
			System.out.println(name);
		}
		System.out.println("----------------------------"+beanNames.length+" beans found --------------------------------");
	}
	
	
	

}