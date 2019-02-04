package teamchat.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import teamchat.data.domain.Industry;
import teamchat.service.IndustryService;

/**
 * 
 * @author gentjan kolicaj
 *
 */
@RestController
@RequestMapping(IndustryRestController.URI)
public class IndustryRestController {
	
	public static final String URI="/api/industries";
	
	@Autowired
	private IndustryService industryService;
	
	
	@RequestMapping(path={"/","/all","/list"},produces="application/json" )
	public List<Industry> getCountries() {
		try {
      	return industryService.getAll();
	
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}


}
