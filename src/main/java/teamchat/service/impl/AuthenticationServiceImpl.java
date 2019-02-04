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
	public AuthenticationServiceImpl(UserDao userDao,UserContactDao userContactDao,PasswordService passwordService,AuthenticationAttemptDao authenticationAttemptDao) {
		this.userDao=userDao;
		this.userContactDao=userContactDao;
		this.passwordService=passwordService;
		this.authenticationAttemptDao=authenticationAttemptDao;
	}

	@Override
	public User authenticate(String emailOrUsername, String password) throws Exception {
		AuthenticationAttempt attempt=null;
	
		String hashedPassword=passwordService.hashPassword(password,HashFunction.SHA_256);
		
		List<User> users=userDao.findByUsername(emailOrUsername);
		
		for(User tmp:users) {
			String tmpPass=tmp.getCredential().getPassword();
			if(tmpPass.equals(hashedPassword)) {
				attempt=new AuthenticationAttempt();
				attempt.setUser(tmp);
				attempt.setStatus(AuthStatus.SUCCESS.getValue());
				attempt.setPlatfrom(Platform.WEB.getValue());
				attempt.setCreationDate(new Date());
				authenticationAttemptDao.save(attempt);
				return tmp;
			}else {
				attempt=new AuthenticationAttempt();
				attempt.setUser(tmp);
				attempt.setStatus(AuthStatus.FAILED.getValue());
				attempt.setPlatfrom(Platform.WEB.getValue());
				attempt.setCreationDate(new Date());
				authenticationAttemptDao.save(attempt);
				return null;
			}
				
		}
		

		
		UserContact userContact=userContactDao.findByEmail(emailOrUsername);
		if(userContact!=null) {
			 User user=userContact.getUser();
			String tmpPass=user.getCredential().getPassword();
			if(tmpPass.equals(hashedPassword)) {
				attempt=new AuthenticationAttempt();
				attempt.setUser(user);
				attempt.setStatus(AuthStatus.SUCCESS.getValue());
				attempt.setPlatfrom(Platform.WEB.getValue());
				attempt.setCreationDate(new Date());
				authenticationAttemptDao.save(attempt);
				return user;
			}else {
				attempt=new AuthenticationAttempt();
				attempt.setUser(user);
				attempt.setStatus(AuthStatus.FAILED.getValue());
				attempt.setPlatfrom(Platform.WEB.getValue());
				attempt.setCreationDate(new Date());
				authenticationAttemptDao.save(attempt);
				return null;
			}
				
		}else {
			attempt=new AuthenticationAttempt();
			attempt.setEmailOrUsername(emailOrUsername);
			attempt.setPassword(password);
			attempt.setStatus(AuthStatus.FAILED_UNKNOWN.getValue());
			attempt.setPlatfrom(Platform.WEB.getValue());
			attempt.setCreationDate(new Date());
			authenticationAttemptDao.save(attempt);
			return null;
			
		}
			
	}

}
