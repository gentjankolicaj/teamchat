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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author gentjan kolicaj
 *
 */
@Entity
@Table(name="team")
public class Team implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5617465605585772145L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="department_id")
	private Department department;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="creator_id")
	private User creator;
	
	
	@Column(name="name")
	private String name;
	
	
	@Column(name="description")
	private String description;
	
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="user_teams",
			joinColumns=@JoinColumn(name="team_id"),
			inverseJoinColumns=@JoinColumn(name="user_id"))
	private List<User> users;
	
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="team")
	private List<Message> messages;
	
	
	@Column(name="creation_date")
	private Date creationDate;
	
	
	@Column(name="deletion_date")
	private Date deletionDate;

	@Column(name="modification_date")
	private Date modificationDate;

	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Team(Long id, Department department, User creator, String name, String description, List<User> users,
			List<Message> messages, Date creationDate, Date deletionDate, Date modificationDate) {
		super();
		this.id = id;
		this.department = department;
		this.creator = creator;
		this.name = name;
		this.description = description;
		this.users = users;
		this.messages = messages;
		this.creationDate = creationDate;
		this.deletionDate = deletionDate;
		this.modificationDate = modificationDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
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


	

}
	
	