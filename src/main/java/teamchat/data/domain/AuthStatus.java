package teamchat.data.domain;

public enum AuthStatus {
	
	SUCCESS("SUCCESS"),FAILED("FAILED"),FAILED_UNKNOWN("FAILED_UNKNOWN");
	private String value;
	
	private AuthStatus(String value) {
		this.value=value;
	}
	
	public String getValue() {
		return value;
	}

}
