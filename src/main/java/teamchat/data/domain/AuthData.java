package teamchat.data.domain;
/**
 * 
 * @author gentjan kolicaj
 *
 */
public class AuthData {
	
	private String password;
	private String email;
	
	public AuthData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthData(String password, String email) {
		super();
		this.password = password;
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
