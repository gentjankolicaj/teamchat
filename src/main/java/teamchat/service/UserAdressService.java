package teamchat.service;

import java.util.List;

import teamchat.data.domain.Country;
import teamchat.data.domain.User;
import teamchat.data.domain.UserAdress;

/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface UserAdressService {
	
	public abstract List<UserAdress> getAll() throws Exception;
	public abstract List<UserAdress> getAllById(List<Long> ids)  throws Exception;
	public abstract UserAdress getById(Long id) throws Exception;
	
	public abstract UserAdress create(UserAdress entity) throws Exception;
	public abstract List<UserAdress> createAll(List<UserAdress> entities) throws Exception;
	
	public abstract UserAdress edit(UserAdress entity) throws Exception;
	public abstract List<UserAdress> editAll(List<UserAdress> entities) throws Exception;
	
	public abstract void deleteById(Long id) throws Exception;
	public abstract void delete(UserAdress entity) throws Exception;
	public abstract void deleteAll(List<UserAdress> entities) throws Exception;
	
	public abstract boolean existById(Long id) throws Exception;
	
	
	//=============================================================================
    public abstract List<UserAdress> getByCityLike(String cityName) throws Exception;
	
	public abstract List<UserAdress> getByStreetLike(String street) throws Exception;
	
	public abstract List<UserAdress> getByCountryId(Long countryId)throws Exception;
	
	public abstract UserAdress createAdress(User user,String street,String city,Country country) throws Exception;
	
	public abstract UserAdress editAdress(Long adressId,String street,String city,Country country) throws Exception;
	
	public abstract UserAdress editAdress(UserAdress adress,String street,String city,Country country) throws Exception;
	
	public abstract void deleteAdress(User user) throws Exception;

}
