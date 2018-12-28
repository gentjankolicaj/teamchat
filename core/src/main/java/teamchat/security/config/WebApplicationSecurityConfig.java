package teamchat.security.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebApplicationSecurityConfig extends WebSecurityConfigurerAdapter{
	
	private static final String[] PROTECTED_URI= {"/api/rest/users/**","/api/rest/countries/**","/api/rest/teams/**"};
	
	private static final String[] FREE_URI= {"/","/**","/home","/home/**","/about","/about/**","/contact","/contact/**","/sign","/sign/**",
			"/jsp","/jsp/**","/thym","/thym/**",
			"/api/rest/**"
			
			};
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers(FREE_URI).permitAll();
	}
	
	
	@Autowired
	private ApplicationContext context;
	
	@PostConstruct
	public void printBeans() {
		String [] beanNames=context.getBeanDefinitionNames();
		System.out.println("---------------------------------------");
		for(String name:beanNames) {
			System.out.println(name);
		}
		System.out.println("----------------------------------------------");
	}
	
	
	

}
