package teamchat.security.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;


//For non spring boot applications,we initalize security in this way
public class WebApplicationSecurityInitializer extends AbstractSecurityWebApplicationInitializer {

	public WebApplicationSecurityInitializer() {
		super(WebApplicationSecurityConfig.class);
		// TODO Auto-generated constructor stub
	}
	
	

}
