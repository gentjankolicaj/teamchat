package teamchat.data.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author gentjan kolicaj
 *
 */
@Entity
@Table(name="user_type")
public class UserType implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name="user_type")
	private String userType;


	public UserType() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UserType(Long id, String userType) {
		super();
		this.id = id;
		this.userType = userType;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
	
	
	

}
