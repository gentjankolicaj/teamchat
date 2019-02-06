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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author gentjan kolicaj
 *
 */
@Entity
@Table(name="department")
public class Department implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5098269253740722343L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="organization_id")
	private Organization organization;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="creator_id")
	private User creator;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="creation_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	@Column(name="deletion_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date deletionDate;
	
	@Column(name="modification_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificationDate;
	
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="department") //join is done at field department in class Team,with column Team.department_id
	private List<Team> teams;


	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Department(Long id, Organization organization, User creator, String name, String description,
			Date creationDate, Date deletionDate, Date modificationDate, List<Team> teams) {
		super();
		this.id = id;
		this.organization = organization;
		this.creator = creator;
		this.name = name;
		this.description = description;
		this.creationDate = creationDate;
		this.deletionDate = deletionDate;
		this.modificationDate = modificationDate;
		this.teams = teams;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Organization getOrganization() {
		return organization;
	}


	public void setOrganization(Organization organization) {
		this.organization = organization;
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
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


	public Date getModificationDate() {
		return modificationDate;
	}


	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}


	public List<Team> getTeams() {
		return teams;
	}


	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}


}
