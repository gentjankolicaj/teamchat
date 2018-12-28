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

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name="name")
	private String name;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="department_id")
	private Department department;
	
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="user_teams",
			joinColumns=@JoinColumn(name="team_id"),
			inverseJoinColumns=@JoinColumn(name="user_id"))
	private List<User> users;
	
	
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="team")
	private List<Chat> chats;
	
	
	@Column(name="creation_date")
	private Date creationDate;
	
	
	
	@Column(name="deletion_date")
	private Date deletionDate;



	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Team(Long id, String name, Department department, List<User> users, List<Chat> chats, Date creationDate,
			Date deletionDate) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.users = users;
		this.chats = chats;
		this.creationDate = creationDate;
		this.deletionDate = deletionDate;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Department getDepartment() {
		return department;
	}



	public void setDepartment(Department department) {
		this.department = department;
	}



	public List<User> getUsers() {
		return users;
	}



	public void setUsers(List<User> users) {
		this.users = users;
	}



	public List<Chat> getChats() {
		return chats;
	}



	public void setChats(List<Chat> chats) {
		this.chats = chats;
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
	
	