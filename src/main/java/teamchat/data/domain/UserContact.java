package teamchat.data.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * 
 * @author gentjan kolicaj
 *
 */
@Entity
@Table(name = "user_contact")
public class UserContact implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7917770997880409954L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@JsonManagedReference
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Column(name = "email")
	private String email;

	@Column(name = "telephone")
	private Long telephone;

	@Column(name = "mobile")
	private Long mobile;

	@Column(name = "postal_code")
	private String postalCode;

	@Column(name = "creation_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	@Column(name = "modification_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificationDate;

	public UserContact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserContact(Long id, User user, String email, Long telephone, Long mobile, String postalCode,
			Date creationDate, Date modificationDate) {
		super();
		this.id = id;
		this.user = user;
		this.email = email;
		this.telephone = telephone;
		this.mobile = mobile;
		this.postalCode = postalCode;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getTelephone() {
		return telephone;
	}

	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
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
