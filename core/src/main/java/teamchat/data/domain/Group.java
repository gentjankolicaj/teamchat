package teamchat.data.domain;

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
import javax.persistence.Table;

/**
 * 
 * @author gentjan kolicaj
 *
 */
@Entity
@Table(name="group")
public class Group {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="group_privilege",
	joinColumns= {@JoinColumn(name="group_id")},
	inverseJoinColumns= {@JoinColumn(name="privilege_id")})
	private List<Privilege> privileges;
	
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="group_members",
	joinColumns= {@JoinColumn(name="group_id")},
	inverseJoinColumns= {@JoinColumn(name="user_id")})
	private List<User> members;
	

	public Group() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Group(Long id, String name, List<Privilege> privileges, List<User> members) {
		super();
		this.id = id;
		this.name = name;
		this.privileges = privileges;
		this.members = members;
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


	public List<Privilege> getPrivileges() {
		return privileges;
	}


	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}


	public List<User> getMembers() {
		return members;
	}


	public void setMembers(List<User> members) {
		this.members = members;
	}

	
}
