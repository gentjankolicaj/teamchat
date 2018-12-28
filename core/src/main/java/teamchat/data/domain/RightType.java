package teamchat.data.domain;
/**
 * 
 * @author gentjan kolicaj
 *
 */
public enum RightType {
	
	READ("READ"),WRITE("WRITE"),UPDATE("UPDATE"),DELETE("DELETE");
	
	private String value;
	
	private RightType(String value) {
		this.value=value;
	}
	
	public String getValue() {
		return value;
	}

}
