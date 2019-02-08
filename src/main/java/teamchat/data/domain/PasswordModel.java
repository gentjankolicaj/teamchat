package teamchat.data.domain;

/**
 * 
 * @author gentjan kolicaj
 *
 */
public class PasswordModel {
	
	private String password;
	private String rePassword;
	public PasswordModel(String password, String rePassword) {
		super();
		this.password = password;
		this.rePassword = rePassword;
	}
	public PasswordModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	
	
}
