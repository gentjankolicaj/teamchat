package teamchat.data.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 
 * @author gentjan kolicaj
 *
 */
@Entity
@Table(name="privilege")
public class Privilege implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7114873212619445315L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="identifier")
	private String identifier;
	
	@Column(name="description")
	private String description;
	
	
	@ManyToMany(fetch=FetchType.LAZY,mappedBy="privileges")
	private List<Group> groups;


	public Privilege() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Privilege(Long id, String identifier, String description, List<Group> groups) {
		super();
		this.id = id;
		this.identifier = identifier;
		this.description = description;
		this.groups = groups;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getIdentifier() {
		return identifier;
	}


	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<Group> getGroups() {
		return groups;
	}


	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	
}
