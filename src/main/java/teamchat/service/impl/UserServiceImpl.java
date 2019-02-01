package teamchat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import teamchat.data.dao.UserAdressDao;
import teamchat.data.dao.UserContactDao;
import teamchat.data.dao.UserDao;
import teamchat.data.domain.User;
import teamchat.service.UserService;



/**
 * 
 * @author gentjan kolicaj
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{
	

	private UserDao userDao;
	
	private UserContactDao userContactDao;
	
	private UserAdressDao userAdressDao;
	
	
    @Autowired
		public UserServiceImpl(UserDao userDao, UserContactDao userContactDao, UserAdressDao userAdressDao) {
		super();
		this.userDao = userDao;
		this.userContactDao = userContactDao;
		this.userAdressDao = userAdressDao;
	}


	@Override
	public List<User> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<User> findAllById(List<Long> ids) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public User findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public User save(User entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<User> saveAll(List<User> entities) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public User update(User entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<User> updateAll(List<User> entities) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteById(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(User entity) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteAll(List<User> entities) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean existById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<User> findUsersByFirstNameLike(String firstName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<User> findUsersByLastNameLike(String lastName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<User> findUsersByUsernameLike(String username) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<User> findUsersByUsername(String username) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	


	


	
	
	

}
