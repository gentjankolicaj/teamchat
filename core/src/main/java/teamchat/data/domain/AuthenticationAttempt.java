package teamchat.data.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * 
 * @author gentjan kolicaj
 *
 */
@Entity
@Table(name="authentication_attempt")
public class AuthenticationAttempt implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name="email_or_username")
	private String emailOrUsername;
	
	@Column(name="password")
	private String password;
	
	@Column(name="status")
	private String status;
	
	@Column(name="platform")
	private String platfrom;
	
	@Column(name="creation_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	
	public AuthenticationAttempt() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AuthenticationAttempt(Long id, User user, String emailOrUsername, String password, String status,
			String platfrom, Date creationDate) {
		super();
		this.id = id;
		this.user = user;
		this.emailOrUsername = emailOrUsername;
		this.password = password;
		this.status = status;
		this.platfrom = platfrom;
		this.creationDate = creationDate;
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


	public String getEmailOrUsername() {
		return emailOrUsername;
	}


	public void setEmailOrUsername(String emailOrUsername) {
		this.emailOrUsername = emailOrUsername;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getPlatfrom() {
		return platfrom;
	}


	public void setPlatfrom(String platfrom) {
		this.platfrom = platfrom;
	}


	public Date getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}
