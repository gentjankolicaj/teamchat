package teamchat.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import teamchat.data.domain.Industry;
import teamchat.service.core.IndustryService;

/**
 * 
 * @author gentjan kolicaj
 *
 */
@RestController
@RequestMapping("/api/rest/industries")
public class IndustryRestController {
	
	@Autowired
	private IndustryService industryService;
	
	@RequestMapping(path={"/","/all","/list"},produces="application/json" )
	public List<Industry> getCountries() {
		try {
      	return industryService.findAll();
	
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}


}
