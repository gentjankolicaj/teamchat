package teamchat.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import teamchat.service.LanguageService;
import teamchat.data.domain.Language;

/**
 * 
 * @author gentjan kolicaj
 *
 */
@RestController
@RequestMapping(LanguageRestController.URI)
public class LanguageRestController {

	public static final String URI = "/api/languages";

	private LanguageService languageService;

	@Autowired
	public LanguageRestController(LanguageService languageService) {
		this.languageService = languageService;
	}

	@RequestMapping(path= {"","/","/all","/list"},produces="application/json")
	public List<Language> getAll() {

		try {

			languageService.getAll();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
