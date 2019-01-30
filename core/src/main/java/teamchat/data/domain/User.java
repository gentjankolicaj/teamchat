package teamchat.data.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
/**
 * 
 * @author gentjan kolicaj
 *
 */
@Entity
@Table(name="user")
@JsonIgnoreProperties({"userAdress","userContact"}) //just for testing purposes
public class User implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="username")
	private String username;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="sex")
	@Enumerated
	private Sex sex;
	

	@Column(name="creation_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	
	@Column(name="deletion_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date deletionDate;
	
	
	@Column(name="modification_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificationDate;

	
	@OneToOne(fetch=FetchType.EAGER,mappedBy="user")
	private Credential credential;
	
	
	@OneToOne(fetch=FetchType.LAZY,mappedBy="user")
	private UserAdress userAdress;
	
	
	@OneToOne(fetch=FetchType.LAZY,mappedBy="user")
	private UserContact userContact;
	
	
	@ManyToMany(fetch=FetchType.LAZY,mappedBy="users")
	private List<Team> teams;
	
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="sender")
	private List<Message> sentMessages;
	
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="receiver")
	private List<Message> receivedMessages;
	
	
	@ManyToMany(fetch=FetchType.LAZY,mappedBy="members")
	private List<Group> groups;


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(Long id, String username, String firstName, String lastName, Sex sex, Date creationDate,
			Date deletionDate, Date modificationDate, Credential credential, UserAdress userAdress,
			UserContact userContact, List<Team> teams, List<Message> sentMessages, List<Message> receivedMessages,
			List<Group> groups) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.creationDate = creationDate;
		this.deletionDate = deletionDate;
		this.modificationDate = modificationDate;
		this.credential = credential;
		this.userAdress = userAdress;
		this.userContact = userContact;
		this.teams = teams;
		this.sentMessages = sentMessages;
		this.receivedMessages = receivedMessages;
		this.groups = groups;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Sex getSex() {
		return sex;
	}


	public void setSex(Sex sex) {
		this.sex = sex;
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


	public Credential getCredential() {
		return credential;
	}


	public void setCredential(Credential credential) {
		this.credential = credential;
	}


	public UserAdress getUserAdress() {
		return userAdress;
	}


	public void setUserAdress(UserAdress userAdress) {
		this.userAdress = userAdress;
	}


	public UserContact getUserContact() {
		return userContact;
	}


	public void setUserContact(UserContact userContact) {
		this.userContact = userContact;
	}


	public List<Team> getTeams() {
		return teams;
	}


	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}


	public List<Message> getSentMessages() {
		return sentMessages;
	}


	public void setSentMessages(List<Message> sentMessages) {
		this.sentMessages = sentMessages;
	}


	public List<Message> getReceivedMessages() {
		return receivedMessages;
	}


	public void setReceivedMessages(List<Message> receivedMessages) {
		this.receivedMessages = receivedMessages;
	}


	public List<Group> getGroups() {
		return groups;
	}


	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}


}
