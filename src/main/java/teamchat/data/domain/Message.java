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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author gentjan kolicaj
 *
 */
@Entity
@Table(name="message")
public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1206420511651841025L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER,optional=true)
	@JoinColumn(name="team_id")
	private Team team;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="sender")
	private User sender;
	
	@ManyToOne(fetch=FetchType.EAGER,optional=true)
	@JoinColumn(name="receiver")
	private User receiver;
	
	
	@Column(name="message")
	private String message;
	
	
	@Column(name="creation_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	@Column(name="deletion_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date deletionDate;
	
	
	@Column(name="modification_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificationDate;
	
	
	@Column(name="modified_by")
	private Long modifiedBy;


	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Message(Long id, Team team, User sender, User receiver, String message, Date creationDate, Date deletionDate,
			Date modificationDate, Long modifiedBy) {
		super();
		this.id = id;
		this.team = team;
		this.sender = sender;
		this.receiver = receiver;
		this.message = message;
		this.creationDate = creationDate;
		this.deletionDate = deletionDate;
		this.modificationDate = modificationDate;
		this.modifiedBy = modifiedBy;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Team getTeam() {
		return team;
	}


	public void setTeam(Team team) {
		this.team = team;
	}


	public User getSender() {
		return sender;
	}


	public void setSender(User sender) {
		this.sender = sender;
	}


	public User getReceiver() {
		return receiver;
	}


	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
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


	public Long getModifiedBy() {
		return modifiedBy;
	}


	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}


	
}
