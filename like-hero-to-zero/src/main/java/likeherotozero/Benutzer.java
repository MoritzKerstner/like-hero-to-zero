package likeherotozero;

public class Benutzer {
	private String name;
	private String passwort;
	private String rolle;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public Benutzer() {
		super();
	}

	public Benutzer(String name, String passwort, String rolle) {
		super();
		this.name = name;
		this.passwort = passwort;
		this.rolle = rolle;
	}

	public String getRolle() {
		return rolle;
	}

	public void setRolle(String rolle) {
		this.rolle = rolle;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Benutzer) {
			Benutzer b = (Benutzer) obj;
			if (b.getName().equals(this.name) && b.getPasswort().equals(this.passwort)) {
				return true;
			}
		}
		return false;
	}
}
