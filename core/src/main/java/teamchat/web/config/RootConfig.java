package teamchat.web.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan({"teamchat"})
public class RootConfig {
	
	@Autowired
	private ApplicationContext context;
	
	@PostConstruct
	public void printBeans() {
		String [] beanNames=context.getBeanDefinitionNames();
		System.out.println();
		System.out.println("---------------------------------After root config init --------------------------------");
		for(String name:beanNames) {
			System.out.println(name);
		}
		System.out.println("----------------------------"+beanNames.length+" beans found --------------------------------");
	}
	
	


}
