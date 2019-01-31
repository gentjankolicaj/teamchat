package teamchat.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import teamchat.data.domain.Country;
import teamchat.service.core.CountryService;


/**
 * 
 * @author gentjan kolicaj
 *
 */
@RestController
@RequestMapping("/api/rest/countries")
public class CountryRestController {
	

	@Autowired
	private CountryService countryService;
	
	
	
	@RequestMapping(path={"/","/all","/list"},produces="application/json" )
	public List<Country> getCountries() {
		try {
      	return countryService.findAll();
	
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}

}
