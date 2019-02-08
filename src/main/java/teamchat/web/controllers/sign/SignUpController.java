package teamchat.web.controllers.sign;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import teamchat.data.domain.Country;
import teamchat.data.domain.Credential;
import teamchat.data.domain.Organization;
import teamchat.data.domain.PasswordModel;
import teamchat.data.domain.User;
import teamchat.data.domain.UserAdress;
import teamchat.data.domain.UserContact;
import teamchat.security.HashFunction;
import teamchat.service.CountryService;
import teamchat.service.CredentialService;
import teamchat.service.OrganizationService;
import teamchat.service.UserAdressService;
import teamchat.service.UserContactService;
import teamchat.service.UserService;

@Controller
@RequestMapping(SignUpController.URI)
public class SignUpController {
	
	protected final static String URI="/signup";
	
	private UserService userService;
	private UserAdressService userAdressService;
	private UserContactService userContactService;
	
	private OrganizationService organizationService;
	private CountryService countryService;
	private CredentialService credentialService;
	

	public SignUpController(UserService userService, UserAdressService userAdressService,
			UserContactService userContactService, OrganizationService organizationService,
			CountryService countryService, CredentialService credentialService) {
		super();
		this.userService = userService;
		this.userAdressService = userAdressService;
		this.userContactService = userContactService;
		this.organizationService = organizationService;
		this.countryService = countryService;
		this.credentialService = credentialService;
	}

	@RequestMapping(path= {"","/","/**"},method=RequestMethod.GET)
	public String showSignUpPage(Model model) throws Exception{
	
		
		User user=new User();
		
		PasswordModel passwordModel=new PasswordModel();
		
		UserContact contact=new UserContact();
		
		UserAdress adress=new UserAdress();
		
		Organization organization=new Organization();
		
		Country country=new Country();
		
		List<Country> countries=countryService.getAll();
		
		model.addAttribute("user", user);
		
		model.addAttribute("passwordModel",passwordModel);
		
		model.addAttribute("adress",adress);
		
		model.addAttribute("contact",contact);
		
		model.addAttribute("organization",organization);
		
		model.addAttribute("countries",countries);
		
		model.addAttribute("country",country);
		
		return "signup";
		
	}
	
	@RequestMapping(path= {"/new"},method=RequestMethod.POST)
	public String saveDetails(@ModelAttribute User user,@ModelAttribute PasswordModel passwordModel,@ModelAttribute UserAdress adress,@ModelAttribute UserContact contact,@ModelAttribute Organization organization,@ModelAttribute Country country) throws Exception{
		if(passwordModel.getPassword().equals(passwordModel.getRePassword())) {
		country=countryService.getById(1L);
		
		Credential credential=new Credential();
		credential.setPassword(passwordModel.getPassword());
		credential.setCreationDate(new Date());
		credential.setHashFunction(HashFunction.NONE.getValue());
		credential.setUser(user);
		
		user.setCreationDate(new Date());
		user.setCredential(credential);
		userService.create(user);
		
		credentialService.create(credential);
		
		adress.setCreationDate(new Date());
		adress.setUser(user);
		adress.setCountry(country);
		userAdressService.create(adress);
		
		contact.setCreationDate(new Date());
		contact.setUser(user);
		userContactService.create(contact);
		
		organization.setCreationDate(new Date());
		organization.setCreator(user);
		organization.setCountry(country);
		organizationService.create(organization);
		
		
		return "redirect:/account";
		}else {
			return "signup";
		}
	}
	

}
