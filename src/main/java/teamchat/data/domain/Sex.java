package teamchat.data.domain;

/**
 * 
 * @author gentjan kolicaj
 *
 */
public enum Sex {
	
	M("M"),F("F") ,O("O");
	
	private String value;
	
	
	private Sex(String value) {
		this.value=value;
	}

	public String getValue() {
		return value;
	}


}
