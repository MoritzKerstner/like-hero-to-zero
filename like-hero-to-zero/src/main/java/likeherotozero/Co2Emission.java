package likeherotozero;

public class Co2Emission {
	private String land;
	private int jahr;
	private double co2Wert;

	public Co2Emission() {
		super();
	}

	public Co2Emission(String land, int jahr, double co2Wert) {
		super();
		this.land = land;
		this.jahr = jahr;
		this.co2Wert = co2Wert;
	}

	public String getLand() {
		return land;
	}

	public void setLand(String land) {
		this.land = land;
	}

	public int getJahr() {
		return jahr;
	}

	public void setJahr(int jahr) {
		this.jahr = jahr;
	}

	public double getCo2Wert() {
		return co2Wert;
	}

	public void setCo2Wert(double co2Wert) {
		this.co2Wert = co2Wert;
	}



}
