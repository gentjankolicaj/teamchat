package teamchat.data.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name="organization")
public class Organization implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4715687820277496646L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="industry_id")
	private Industry industry;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="creator_id")
	private User creator;
	
	@Column(name="name")
	private String name;
	
	@Column(name="city")
	private String city;
	
	@Column(name="adress")
	private String adress;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="country_id")
	private Country country;
	
	@Column(name="url")
	private String url;
	
	@Column(name="email")
	private String organizationEmail;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="description")
	private String description;

	@OneToMany(fetch=FetchType.LAZY,mappedBy="organization")
	private List<Department> departments;
	
	@Column(name="creation_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	@Column(name="deletion_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date deletionDate;

	
	public Organization() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Organization(Long id, Industry industry, User creator, String name, String city, String adress,
			Country country, String url, String organizationEmail, String phone, String description,
			List<Department> departments, Date creationDate, Date deletionDate) {
		super();
		this.id = id;
		this.industry = industry;
		this.creator = creator;
		this.name = name;
		this.city = city;
		this.adress = adress;
		this.country = country;
		this.url = url;
		this.organizationEmail = organizationEmail;
		this.phone = phone;
		this.description = description;
		this.departments = departments;
		this.creationDate = creationDate;
		this.deletionDate = deletionDate;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Industry getIndustry() {
		return industry;
	}


	public void setIndustry(Industry industry) {
		this.industry = industry;
	}


	public User getCreator() {
		return creator;
	}


	public void setCreator(User creator) {
		this.creator = creator;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getAdress() {
		return adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}


	public Country getCountry() {
		return country;
	}


	public void setCountry(Country country) {
		this.country = country;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getOrganizationEmail() {
		return organizationEmail;
	}


	public void setOrganizationEmail(String organizationEmail) {
		this.organizationEmail = organizationEmail;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<Department> getDepartments() {
		return departments;
	}


	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}


	public Date getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}


	public Date getDeletionDate() {
		return deletionDate;
	}


	public void setDeletionDate(Date deletionDate) {
		this.deletionDate = deletionDate;
	}


	
}
