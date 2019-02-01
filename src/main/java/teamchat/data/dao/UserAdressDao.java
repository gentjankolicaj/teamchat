package teamchat.data.dao;

import java.util.List;

import teamchat.data.domain.UserAdress;


/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface UserAdressDao extends CrudDao<UserAdress,Long>{
	
	public abstract List<UserAdress> findUserAdressByCityLike(String cityName) throws Exception;
	
	public abstract List<UserAdress> findUserAdressByStreetLike(String street) throws Exception;
	
	public abstract List<UserAdress> findUserAdressByCountryId(Long countryId)throws Exception;
	
}
