package teamchat.data.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author gentjan kolicaj
 *
 */
@Entity
@Table(name="industry")
@JsonIgnoreProperties({"organizations"})
public class Industry implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8487382726403224343L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	
	@Column(name="name")
	private String name;
	
	
	@Column(name="description")
	private String description;

	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="industry")
	private List<Organization> organizations;


	public Industry() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Industry(Long id, String name, String description, List<Organization> organizations) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.organizations = organizations;
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<Organization> getOrganizations() {
		return organizations;
	}


	public void setOrganizations(List<Organization> organizations) {
		this.organizations = organizations;
	}


	

}
