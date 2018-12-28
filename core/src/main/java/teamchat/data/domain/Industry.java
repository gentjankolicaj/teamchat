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

/**
 * 
 * @author gentjan kolicaj
 *
 */
@Entity
@Table(name="industry")
public class Industry implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name="name")
	private String name;

	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="industry")
	private List<Organization> organization;


	public Industry() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Industry(Long id, String name, List<Organization> organization) {
		super();
		this.id = id;
		this.name = name;
		this.organization = organization;
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


	public List<Organization> getOrganization() {
		return organization;
	}


	public void setOrganization(List<Organization> organization) {
		this.organization = organization;
	}
	
	

}
