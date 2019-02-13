package teamchat.service;


import teamchat.data.domain.Credential;
import teamchat.data.domain.Organization;
import teamchat.data.domain.PasswordModel;
import teamchat.data.domain.User;
import teamchat.data.domain.UserAdress;
import teamchat.data.domain.UserContact;

/**
 * 
 * @author gentjan kolicaj
 *
 */
public interface SignService {
	
	public abstract User signUp(User user,UserContact userContact,UserAdress userAdress,PasswordModel passwordModel,Long countryId,Organization organization) throws Exception;
	
	public abstract User signUp(User user,UserContact userContact,UserAdress userAdress,PasswordModel passwordModel,Long countryId,Organization organization,Credential credential) throws Exception;
	
	public abstract User signIn(String email,String password) throws Exception;
	

}
