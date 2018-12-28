package teamchat.data.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author gentjan kolicaj
 *
 */
@Entity
@Table(name = "rights")
public class Right implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	

	@Column(name = "rights")
	@Enumerated
	@ElementCollection(targetClass = RightType.class)
	private List<RightType> rights;

	public Right() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Right(Long id, User user, List<RightType> rights) {
		super();
		this.id = id;
		this.user = user;
		this.rights = rights;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<RightType> getRights() {
		return rights;
	}

	public void setRights(List<RightType> rights) {
		this.rights = rights;
	}

	
	
}
