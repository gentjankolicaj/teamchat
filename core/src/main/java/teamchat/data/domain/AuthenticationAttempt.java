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
@Table(name="attempt")
public class Attempt implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(optional=false)
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name="status")
	private String status;
	
	@Column(name="platform")
	private String platfrom;
	
	@Column(name="creation_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	

	public Attempt() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Attempt(Long id, User user, String status, String platfrom, Date creationDate) {
		super();
		this.id = id;
		this.user = user;
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
