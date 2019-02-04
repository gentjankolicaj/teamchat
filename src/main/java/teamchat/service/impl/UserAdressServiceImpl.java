package teamchat.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import teamchat.data.dao.UserAdressDao;
import teamchat.data.domain.Country;
import teamchat.data.domain.User;
import teamchat.data.domain.UserAdress;
import teamchat.exception.UserAdressException;
import teamchat.exception.UserException;
import teamchat.service.UserAdressService;

/**
 * 
 * @author gentjan kolicaj
 *
 */
@Service
@Transactional
public class UserAdressServiceImpl implements UserAdressService{
	
	private UserAdressDao userAdressDao;
	
	@Autowired
	public UserAdressServiceImpl(UserAdressDao userAdressDao) {
		super();
		this.userAdressDao = userAdressDao;
	}

	@Override
	public List<UserAdress> getAll() throws Exception {
		return userAdressDao.findAll();
	}

	@Override
	public List<UserAdress> getAllById(List<Long> ids) throws Exception {
		return userAdressDao.findAllById(ids);
	}

	@Override
	public UserAdress getById(Long id) throws Exception {
		return userAdressDao.findById(id);
	}

	@Override
	public UserAdress create(UserAdress entity) throws Exception {
	return userAdressDao.save(entity);
	}

	@Override
	public List<UserAdress> createAll(List<UserAdress> entities) throws Exception {
		return userAdressDao.saveAll(entities);
	}

	@Override
	public UserAdress edit(UserAdress entity) throws Exception {
		return userAdressDao.update(entity);
	}

	@Override
	public List<UserAdress> editAll(List<UserAdress> entities) throws Exception {
		return userAdressDao.updateAll(entities);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		userAdressDao.deleteById(id);
		
	}

	@Override
	public void delete(UserAdress entity) throws Exception {
		userAdressDao.delete(entity);
		
	}

	@Override
	public void deleteAll(List<UserAdress> entities) throws Exception {
		userAdressDao.deleteAll(entities);
		
	}

	@Override
	public boolean existById(Long id) throws Exception {
		return userAdressDao.existById(id);
	}

	@Override
	public List<UserAdress> getByCityLike(String cityName) throws Exception {
		return userAdressDao.findByCityLike(cityName);
	}

	@Override
	public List<UserAdress> getByStreetLike(String street) throws Exception {
		return userAdressDao.findByStreetLike(street);
	}

	@Override
	public List<UserAdress> getByCountryId(Long countryId) throws Exception {
		return userAdressDao.findByCountryId(countryId);
	}

	@Override
	public UserAdress createAdress(User user, String street, String city, Country country) throws Exception {
		UserAdress userAdress=new UserAdress();
		userAdress.setUser(user);
		userAdress.setStreet(street);
		userAdress.setCity(city);
		userAdress.setCountry(country);
		userAdress.setCreationDate(new Date());
		userAdress.setModificationDate(null);
		
		return userAdressDao.save(userAdress);
	}

	@Override
	public UserAdress editAdress(Long adressId, String street, String city, Country country) throws Exception {
		UserAdress userAdress=userAdressDao.findById(adressId);
		if(userAdress==null)
			throw new UserAdressException("User adress with id "+adressId+" doesn't exists.");
		
		userAdress.setStreet(street);
		userAdress.setCity(city);
		userAdress.setCountry(country);
		userAdress.setModificationDate(new Date());
		return userAdressDao.update(userAdress);
	}

	@Override
	public UserAdress editAdress(UserAdress userAdress, String street, String city, Country country) throws Exception {
		if(userAdress==null)
			throw new UserAdressException("User adress doesn't exists.Reference is null");
		
		userAdress.setStreet(street);
		userAdress.setCity(city);
		userAdress.setCountry(country);
		userAdress.setModificationDate(new Date());
		return userAdressDao.update(userAdress);
		
	}

	@Override
	public void deleteAdress(User user) throws Exception {
		if(user==null)
			throw new UserException("User dosen't exists.Reference is null");
		
		UserAdress userAdress=user.getUserAdress();
		userAdressDao.delete(userAdress);;
		
	}
	

}
