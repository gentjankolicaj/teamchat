package teamchat.data.dao;

import java.util.List;

import teamchat.data.domain.UserAdress;


/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface UserAdressDao {
	
	
    public abstract List<UserAdress> findAll() throws Exception;
	
	public abstract UserAdress findById(Long id) throws Exception;
	
	public abstract List<UserAdress> findByCity(String cityName) throws Exception;
	
	public abstract List<UserAdress> findByStreet(String street) throws Exception;
	
	public abstract List<UserAdress> findByCountryId(Long countryId)throws Exception;
	
	public abstract void save(UserAdress userAdress) throws Exception;
	
	public abstract void update(UserAdress userAdress) throws Exception;
	
	public abstract void delete(UserAdress userAdress) throws Exception;

	public abstract int deleteById(Long id) throws Exception;	

}
