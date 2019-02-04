package teamchat.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(RootController.URI)
public class RootController {
	
	protected final static String URI="/";

	public RootController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(path= {"","index","index.html","index.jsp","index.xhtml"})
	public String getRootPage() {
		return "index";
	}

}
