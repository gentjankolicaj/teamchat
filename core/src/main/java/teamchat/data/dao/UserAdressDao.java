package teamchat.data.dao;

import java.util.List;

import teamchat.data.domain.UserAdress;


/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface UserAdressDao extends CrudDao<UserAdress,Long>{
	
	public abstract List<UserAdress> findByCity(String cityName) throws Exception;
	
	public abstract List<UserAdress> findByStreet(String street) throws Exception;
	
	public abstract List<UserAdress> findByCountryId(Long countryId)throws Exception;
	
}
