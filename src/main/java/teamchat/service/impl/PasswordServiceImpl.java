package teamchat.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import teamchat.data.domain.Credential;
import teamchat.data.domain.User;
import teamchat.security.HashFunction;
import teamchat.service.PasswordService;
/**
 * 
 * @author gentjan kolicaj
 *
 */
@Service
public class PasswordServiceImpl implements PasswordService {
	
	

	public PasswordServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String hashPassword(String password, HashFunction function) throws Exception {
		return password;
	}

	@Override
	public List<String> hashPasswords(List<String> passwords, HashFunction function) throws Exception {
		return passwords;
	}

	@Override
	public User hashPassword(User user, HashFunction function) throws Exception {
		return user;
	}

	@Override
	public Credential hashPassword(Credential credential, HashFunction hashFunction) throws Exception {
		return credential;
	}

}
