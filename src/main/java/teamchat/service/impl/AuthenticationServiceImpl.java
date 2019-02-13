package teamchat.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import teamchat.data.dao.AuthenticationAttemptDao;
import teamchat.data.dao.UserContactDao;
import teamchat.data.domain.AuthStatus;
import teamchat.data.domain.AuthenticationAttempt;
import teamchat.data.domain.Platform;
import teamchat.data.domain.User;
import teamchat.data.domain.UserContact;
import teamchat.exception.domain.CredentialException;
import teamchat.exception.domain.UserContactException;
import teamchat.exception.domain.UserException;
import teamchat.security.config.WebApplicationSecurityConfig;
import teamchat.service.AuthenticationService;
import teamchat.service.PasswordService;

/**
 * 
 * @author gentjan kolicaj
 *
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	private UserContactDao userContactDao;
	private PasswordService passwordService;
	private AuthenticationAttemptDao authenticationAttemptDao;

	@Autowired
	public AuthenticationServiceImpl(UserContactDao userContactDao, PasswordService passwordService,
			AuthenticationAttemptDao authenticationAttemptDao) {
		this.userContactDao = userContactDao;
		this.passwordService = passwordService;
		this.authenticationAttemptDao = authenticationAttemptDao;
	}

	@Transactional(noRollbackFor=Exception.class) //avoid transaction from rolling back.//because we need to keep record of attempts.
	@Override
	public User authenticate(String email, String password) throws Exception {
		AuthenticationAttempt attempt = null;

		String hashedPassword = passwordService.hashPassword(password,
				WebApplicationSecurityConfig.PASSWORD_HASHING_FUNCTION);

		try {

			UserContact userContact = userContactDao.findByEmail(email);

			if (userContact != null) {
				User user = userContact.getUser();
				if (user != null) {
					String tmpPass = user.getCredential().getPassword();
					if (tmpPass.equals(hashedPassword)) {
						attempt = new AuthenticationAttempt();
						attempt.setUser(user);
						attempt.setStatus(AuthStatus.SUCCESS.getValue());
						attempt.setPlatfrom(Platform.WEB.getValue());
						attempt.setCreationDate(new Date());
						authenticationAttemptDao.save(attempt);
						return user;
					} else {
						attempt = new AuthenticationAttempt();
						attempt.setUser(user);
						attempt.setStatus(AuthStatus.FAILED.getValue());
						attempt.setPlatfrom(Platform.WEB.getValue());
						attempt.setCreationDate(new Date());
						authenticationAttemptDao.save(attempt);
						throw new CredentialException("Passwords don't match.");
					}
				} else
					throw new UserException("User with email " + email + " not found.");

			} else {
				attempt = new AuthenticationAttempt();
				attempt.setEmailOrUsername(email);
				attempt.setUser(null);
				attempt.setPassword(password);
				attempt.setStatus(AuthStatus.FAILED_UNKNOWN.getValue());
				attempt.setPlatfrom(Platform.WEB.getValue());
				attempt.setCreationDate(new Date());
				authenticationAttemptDao.save(attempt);

				throw new UserContactException("User email " + email + " not found.");

			}

		} catch (Exception e) {

			attempt = new AuthenticationAttempt();
			attempt.setEmailOrUsername(email);
			attempt.setUser(null);
			attempt.setPassword(password);
			attempt.setStatus(AuthStatus.FAILED_UNKNOWN.getValue());
			attempt.setPlatfrom(Platform.WEB.getValue());
			attempt.setCreationDate(new Date());
			authenticationAttemptDao.save(attempt);

			throw new UserContactException("User email " + email + " not found.");
		}

	}

}
