package teamchat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import teamchat.data.dao.CredentialDao;
import teamchat.data.domain.Credential;
import teamchat.data.domain.User;
import teamchat.security.HashFunction;
import teamchat.service.CredentialService;
import teamchat.service.PasswordService;

/**
 * 
 * @author gentjan kolicaj
 *
 */
@Service
@Transactional
public class CredentialServiceImpl implements CredentialService {
	
	private CredentialDao credentialDao;
	private PasswordService passwordService;
	
	@Autowired
	public CredentialServiceImpl(CredentialDao credentialDao, PasswordService passwordService) {
		super();
		this.credentialDao = credentialDao;
		this.passwordService = passwordService;
	}

	@Override
	public List<Credential> getAll() throws Exception {
		return credentialDao.findAll();
	}

	@Override
	public List<Credential> getAllById(List<Long> ids) throws Exception {
		return credentialDao.findAllById(ids);
	}

	@Override
	public Credential getById(Long id) throws Exception {
		return credentialDao.findById(id);
	}

	@Override
	public Credential create(Credential entity) throws Exception {
		return credentialDao.save(entity);
	}

	@Override
	public List<Credential> createAll(List<Credential> entities) throws Exception {
		return credentialDao.saveAll(entities);
	}

	@Override
	public Credential edit(Credential entity) throws Exception {
		return credentialDao.update(entity);
	}

	@Override
	public List<Credential> editAll(List<Credential> entities) throws Exception {
		return credentialDao.updateAll(entities);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		 credentialDao.deleteById(id);
	}

	@Override
	public void delete(Credential entity) throws Exception {
		credentialDao.delete(entity);
		
	}

	@Override
	public void deleteAll(List<Credential> entities) throws Exception {
		credentialDao.deleteAll(entities);
		
	}

	@Override
	public boolean existById(Long id) throws Exception {
		return credentialDao.existById(id);
	}

	@Override
	public Credential changePassword(User user, String newPassword) throws Exception {
		Credential credential=user.getCredential();
		String hashedNewPassword=passwordService.hashPassword(newPassword, HashFunction.SHA_256);
		credential.setPassword(hashedNewPassword);
		return credentialDao.update(credential);
	}
	
	

}
