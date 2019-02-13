package teamchat.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import teamchat.data.domain.AuthStatus;
import teamchat.data.domain.AuthenticationAttempt;
import teamchat.data.domain.Country;
import teamchat.data.domain.Credential;
import teamchat.data.domain.Organization;
import teamchat.data.domain.PasswordModel;
import teamchat.data.domain.Platform;
import teamchat.data.domain.User;
import teamchat.data.domain.UserAdress;
import teamchat.data.domain.UserContact;
import teamchat.security.HashFunction;
import teamchat.security.config.WebApplicationSecurityConfig;
import teamchat.service.AuthenticationAttemptService;
import teamchat.service.CountryService;
import teamchat.service.CredentialService;
import teamchat.service.OrganizationService;
import teamchat.service.PasswordService;
import teamchat.service.SignService;
import teamchat.service.UserAdressService;
import teamchat.service.UserContactService;
import teamchat.service.UserService;

/**
 * 
 * @author gentjan kolicaj
 *
 */
@Service
public class SignServiceImpl implements SignService {

	private UserService userService;
	private UserAdressService userAdressService;
	private UserContactService userContactService;

	private OrganizationService organizationService;
	private CountryService countryService;
	private CredentialService credentialService;
	private AuthenticationAttemptService authAttemptService;
	private PasswordService passwordService;

	
    @Autowired
	public SignServiceImpl(UserService userService, UserAdressService userAdressService,
			UserContactService userContactService, OrganizationService organizationService,
			CountryService countryService, CredentialService credentialService,
			AuthenticationAttemptService authAttemptService, PasswordService passwordService) {
		super();
		this.userService = userService;
		this.userAdressService = userAdressService;
		this.userContactService = userContactService;
		this.organizationService = organizationService;
		this.countryService = countryService;
		this.credentialService = credentialService;
		this.authAttemptService = authAttemptService;
		this.passwordService = passwordService;
	}

	@Transactional(rollbackFor = Exception.class) //rolls back transactions for every exception
	@Override
	public User signUp(User user, UserContact userContact, UserAdress userAdress, PasswordModel passwordModel,
			Long countryId, Organization organization) throws Exception {

		Country country = countryService.getById(countryId);

		Credential credential = new Credential();
		credential.setPassword(passwordModel.getPassword());
		credential.setCreationDate(new Date());
		credential.setHashFunction(HashFunction.NONE.getValue());
		
		//hashPassword
		credential=passwordService.hashPassword(credential, WebApplicationSecurityConfig.PASSWORD_HASHING_FUNCTION);
		credential.setUser(user);

		user.setCreationDate(new Date());
		user.setCredential(credential);
		User tmp=userService.create(user);

		credentialService.create(credential);

		userAdress.setCreationDate(new Date());
		userAdress.setUser(user);
		userAdress.setCountry(country);
		userAdressService.create(userAdress);

		userContact.setCreationDate(new Date());
		userContact.setUser(user);
		userContactService.create(userContact);

		organization.setCreationDate(new Date());
		organization.setCreator(user);
		organization.setCountry(country);
		organizationService.create(organization);

		AuthenticationAttempt firstAuthAttempt = new AuthenticationAttempt();
		firstAuthAttempt.setCreationDate(new Date());
		firstAuthAttempt.setStatus(AuthStatus.SUCCESS.getValue());
		firstAuthAttempt.setUser(user);
		firstAuthAttempt.setPlatfrom(Platform.WEB.getValue());
		authAttemptService.create(firstAuthAttempt);

		return tmp;
	}

	@Override
	public User signIn(String email, String password) throws Exception {
		return null;

	}

	@Override
	public User signUp(User user, UserContact userContact, UserAdress userAdress, PasswordModel passwordModel,
			Long countryId, Organization organization, Credential credential) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(rollbackFor = Exception.class) 
	@Override
	public User signUp(User user, UserContact userContact, UserAdress userAdress, PasswordModel passwordModel,
			Long countryId) throws Exception {
		Country country = countryService.getById(countryId);

		Credential credential = new Credential();
		credential.setPassword(passwordModel.getPassword());
		credential.setCreationDate(new Date());
		credential.setHashFunction(HashFunction.NONE.getValue());
		
		//hashPassword
		credential=passwordService.hashPassword(credential, WebApplicationSecurityConfig.PASSWORD_HASHING_FUNCTION);
		credential.setUser(user);

		user.setCreationDate(new Date());
		user.setCredential(credential);
		User tmp=userService.create(user);

		credentialService.create(credential);

		userAdress.setCreationDate(new Date());
		userAdress.setUser(user);
		userAdress.setCountry(country);
		userAdressService.create(userAdress);

		userContact.setCreationDate(new Date());
		userContact.setUser(user);
		userContactService.create(userContact);

		AuthenticationAttempt firstAuthAttempt = new AuthenticationAttempt();
		firstAuthAttempt.setCreationDate(new Date());
		firstAuthAttempt.setStatus(AuthStatus.SUCCESS.getValue());
		firstAuthAttempt.setUser(user);
		firstAuthAttempt.setPlatfrom(Platform.WEB.getValue());
		authAttemptService.create(firstAuthAttempt);

		return tmp;
	}

	
}
