package teamchat.data.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * 
 * @author gentjan kolicaj
 *
 */
@Entity
@Table(name="credential")
public class Credential implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6088590874742961507L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name="password")
	private String password;
	
	
	@Column(name="hash_function")
	private String hashFunction;
	
	@Column(name="creation_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	@Column(name="modification_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificationDate;
	

	public Credential() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Credential(Long id, User user, String password, String hashFunction, Date creationDate,
			Date modificationDate) {
		super();
		this.id = id;
		this.user = user;
		this.password = password;
		this.hashFunction = hashFunction;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getHashFunction() {
		return hashFunction;
	}


	public void setHashFunction(String hashFunction) {
		this.hashFunction = hashFunction;
	}


	public Date getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}


	public Date getModificationDate() {
		return modificationDate;
	}


	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}


}
