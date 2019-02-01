package teamchat.service.core.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import teamchat.data.dao.UserAdressDao;
import teamchat.data.dao.UserContactDao;
import teamchat.data.dao.UserDao;
import teamchat.data.domain.User;
import teamchat.service.core.UserService;



/**
 * 
 * @author gentjan kolicaj
 *
 */
@Service
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
	
	


	@Transactional
	@Override
	public List<User> findAll() throws Exception {
		return userDao.findAll();
	}



	
	
	

}
