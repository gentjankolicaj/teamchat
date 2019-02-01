package teamchat.data.domain;

public enum Platform {
	
	WEB("WEB"),DESKTOP("DESKTOP"),MOBILE("MOBILE");
	
	private String value;
	
	private Platform(String value) {
		this.value=value;
	}

	public String getValue() {
		return value;
	}
}
