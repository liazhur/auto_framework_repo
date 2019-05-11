package os;

public enum OSType {
	MACOS("mac", "macos"), LINUX("linux", "linux"), WINDOWS("win", "win");

	private String name;
	private String suffix;

	OSType(String name, String suffix) {
		this.name = name;
		this.suffix = suffix;
	}

	private static OSType getOSFromPropertyFile(String name) {
		for (OSType os : OSType.values()) {
			if (os.getName().equalsIgnoreCase(name))
				return os;
		}
		throw new IllegalArgumentException(String.format("%s OS type is not implemented.", name));
	}

	public static OSType getOS() {
		String systemOS = System.getProperty("os.name").toLowerCase();
		for (OSType os : OSType.values()) {
			if (systemOS.contains(os.getName().toLowerCase()))
				return os;
		}
		throw new IllegalArgumentException(String.format("%s OS type is not implemented.", systemOS));
	}

	public String getName() {
		return name;
	}

	public String getSuffix() {
		return suffix;
	}
}
