package teamchat.rest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author gentjan kolicaj
 *
 */
@RestController
@RequestMapping(LanguageRestController.URI)
public class LanguageRestController {
	
	public static final String URI="/api/languages";

}
