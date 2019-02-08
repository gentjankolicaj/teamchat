package teamchat.security;

public enum HashFunction {
	
	MD5("MD5"),SHA_512("SHA-512"),SHA_256("SHA-256"),NONE("NONE");
	
	private String value;
	
	private HashFunction(String value) {
		this.value=value;
	}
	
	public String getValue() {
		return value;
	}

}
