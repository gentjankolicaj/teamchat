package teamchat.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import teamchat.data.dao.AuthenticationAttemptDao;
import teamchat.data.dao.UserContactDao;
import teamchat.data.dao.UserDao;
import teamchat.data.domain.AuthStatus;
import teamchat.data.domain.AuthenticationAttempt;
import teamchat.data.domain.Platform;
import teamchat.data.domain.User;
import teamchat.data.domain.UserContact;
import teamchat.exception.domain.UserContactException;
import teamchat.exception.domain.UserException;
import teamchat.security.HashFunction;
import teamchat.service.AuthenticationService;
import teamchat.service.PasswordService;

/**
 * 
 * @author gentjan kolicaj
 *
 */
@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {

	private UserDao userDao;
	private UserContactDao userContactDao;
	private PasswordService passwordService;
	private AuthenticationAttemptDao authenticationAttemptDao;

	@Autowired
	public AuthenticationServiceImpl(UserDao userDao, UserContactDao userContactDao, PasswordService passwordService,
			AuthenticationAttemptDao authenticationAttemptDao) {
		this.userDao = userDao;
		this.userContactDao = userContactDao;
		this.passwordService = passwordService;
		this.authenticationAttemptDao = authenticationAttemptDao;
	}

	@Override
	public User authenticate(String email, String password) throws Exception {
		AuthenticationAttempt attempt = null;

		String hashedPassword = passwordService.hashPassword(password, HashFunction.SHA_256);

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
					return null;
				}
			} else
				throw new UserException("User with email " + email + " not found.");

		} else {
			attempt = new AuthenticationAttempt();
			attempt.setEmailOrUsername(email);
			attempt.setPassword(password);
			attempt.setStatus(AuthStatus.FAILED_UNKNOWN.getValue());
			attempt.setPlatfrom(Platform.WEB.getValue());
			attempt.setCreationDate(new Date());
			authenticationAttemptDao.save(attempt);

			throw new UserContactException("User email " + email + " not found.");

		}

	}

}
