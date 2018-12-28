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

/**
 * 
 * @author gentjan kolicaj
 *
 */
@Entity
@Table(name="department")
public class Department implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="organization_id")
	private Organization organization;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="creator_id")
	private User creator;
	
	
	@Column(name="creation_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	@Column(name="deletion_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date deletionDate;
	
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="department")
	private List<Team> teams;


	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Department(Long id, Organization organization, String name, User creator, Date creationDate,
			Date deletionDate, List<Team> teams) {
		super();
		this.id = id;
		this.organization = organization;
		this.name = name;
		this.creator = creator;
		this.creationDate = creationDate;
		this.deletionDate = deletionDate;
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



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public User getCreator() {
		return creator;
	}



	public void setCreator(User creator) {
		this.creator = creator;
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



	public List<Team> getTeams() {
		return teams;
	}



	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	
	


}
