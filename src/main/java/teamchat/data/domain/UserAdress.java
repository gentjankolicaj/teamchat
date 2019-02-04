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
import javax.persistence.ManyToOne;
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
@Table(name="user_adress")
public class UserAdress implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3964805147362067167L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name="city")
	private String city;
	
	@Column(name="street")
	private String street;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="country_id")
	private Country country;
	
	
	@Column(name="creation_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	
	@Column(name="modification_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificationDate;

	public UserAdress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserAdress(Long id, User user, String city, String street, Country country, Date creationDate, Date modificationDate) {
		super();
		this.id = id;
		this.user = user;
		this.city = city;
		this.street = street;
		this.country = country;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
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
