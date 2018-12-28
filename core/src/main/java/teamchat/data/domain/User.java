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
@JsonIgnoreProperties({"userAdress","userContact"})
public class User implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	
	@Column(name="gender")
	@Enumerated
	private Gender gender;
	
	
	
	@ManyToOne(optional=false)
	@JoinColumn(name="user_type")
	private UserType userType;
	
	
	@Column(name="username")
	private String username;
	
	
	@OneToOne(fetch=FetchType.EAGER,mappedBy="user")
	private Authentication authentication;
	
	
	
	@OneToOne(fetch=FetchType.LAZY,mappedBy="user")
	private Right right;
	
	
	@OneToOne(fetch=FetchType.LAZY,mappedBy="user")
	private UserAdress userAdress;
	
	
	@OneToOne(fetch=FetchType.LAZY,mappedBy="user")
	private UserContact userContact;
	
	
	@ManyToMany(fetch=FetchType.LAZY,mappedBy="users")
	private List<Team> teams;
	
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="sender")
	private List<Chat> sentChats;
	
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="receiver")
	private List<Chat> receivedChats;
	
	
	@Column(name="creation_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	
	@Column(name="deletion_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date deletionDate;
	
	
	@Column(name="modification_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificationDate;

	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(Long id, String firstName, String lastName, Gender gender, UserType userType, String username,
			Authentication authentication, Right right, UserAdress userAdress, UserContact userContact,
			List<Team> teams, List<Chat> sentChats, List<Chat> receivedChats, Date creationDate, Date deletionDate,
			Date modificationDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.userType = userType;
		this.username = username;
		this.authentication = authentication;
		this.right = right;
		this.userAdress = userAdress;
		this.userContact = userContact;
		this.teams = teams;
		this.sentChats = sentChats;
		this.receivedChats = receivedChats;
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


	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}


	public UserType getUserType() {
		return userType;
	}


	public void setUserType(UserType userType) {
		this.userType = userType;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public Authentication getAuthentication() {
		return authentication;
	}


	public void setAuthentication(Authentication authentication) {
		this.authentication = authentication;
	}


	public Right getRight() {
		return right;
	}


	public void setRight(Right right) {
		this.right = right;
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


	public List<Chat> getSentChats() {
		return sentChats;
	}


	public void setSentChats(List<Chat> sentChats) {
		this.sentChats = sentChats;
	}


	public List<Chat> getReceivedChats() {
		return receivedChats;
	}


	public void setReceivedChats(List<Chat> receivedChats) {
		this.receivedChats = receivedChats;
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
