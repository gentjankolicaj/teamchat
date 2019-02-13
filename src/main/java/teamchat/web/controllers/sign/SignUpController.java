package teamchat.web.controllers.sign;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import teamchat.data.domain.Country;
import teamchat.data.domain.Organization;
import teamchat.data.domain.PasswordModel;
import teamchat.data.domain.User;
import teamchat.data.domain.UserAdress;
import teamchat.data.domain.UserContact;
import teamchat.service.CountryService;
import teamchat.service.SignService;
/**
 * 
 * @author gentjan kolicaj
 *
 */
@Controller
@RequestMapping(SignUpController.URI)
public class SignUpController {

	protected final static String URI = "/signup";

	private CountryService countryService;
	private SignService signService;

	@Autowired
	public SignUpController(CountryService countryService, SignService signService) {
		super();
		this.countryService = countryService;
		this.signService = signService;
	}

	@RequestMapping(path = { "", "/", "/**" }, method = RequestMethod.GET)
	public String showSignUpPage(Model model) throws Exception {

		User user = new User();

		PasswordModel passwordModel = new PasswordModel();

		UserContact userContact = new UserContact();

		UserAdress userAdress = new UserAdress();

		Organization organization = new Organization();

		List<Country> countries = countryService.getAll();

		model.addAttribute("user", user);

		model.addAttribute("passwordModel", passwordModel);

		model.addAttribute("userAdress", userAdress);

		model.addAttribute("userContact", userContact);

		model.addAttribute("organization", organization);

		model.addAttribute("countries", countries);

		return "signup";

	}

	@RequestMapping(path = { "/new" }, method = RequestMethod.GET)
	public String saveDetails(@ModelAttribute User user, @ModelAttribute PasswordModel passwordModel,
			@ModelAttribute("userAdress") UserAdress userAdress, @ModelAttribute("userContact") UserContact userContact,
			@ModelAttribute Organization organization, @RequestParam("countryId") Long countryId,RedirectAttributes redirectAttributes) throws Exception {
		if (passwordModel.getPassword().equals(passwordModel.getRePassword())) {

			try {

				User tmp=signService.signUp(user, userContact, userAdress, passwordModel, countryId, organization);
				
		  	     redirectAttributes.addFlashAttribute("signedUpUser",tmp); //added as an attribute to be carried during redirect,this is the only way not (model.addAttribute)

			} catch (Exception e) {
				e.printStackTrace();
				
				return "redirect:/signup";
			}

			return "redirect:/account/up";
			
		} else 
			return "redirect:/signup";
		
	}

}
