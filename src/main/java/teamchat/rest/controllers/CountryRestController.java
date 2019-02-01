package teamchat.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import teamchat.data.domain.Country;
import teamchat.service.CountryService;


/**
 * 
 * @author gentjan kolicaj
 *
 */
@RestController
@RequestMapping(CountryRestController.URI)
public class CountryRestController {
	
	public static final String URI="/api/countries";
	

	@Autowired
	private CountryService countryService;
	
	
	
	@RequestMapping(path={"/","/all","/list"},produces="application/json" )
	public List<Country> getCountries() {
		try {
      	return countryService.getAll();
	
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}

}
