package teamchat.data.domain;

/**
 * 
 * @author gentjan kolicaj
 *
 */
public enum Gender {
	
	FEMALE("FEMALE"),MALE("MALE") ,OTHER("OTHER");
	
	private String value;
	
	
	private Gender(String value) {
		this.value=value;
	}


	public String getValue() {
		return value;
	}
	
	

}
