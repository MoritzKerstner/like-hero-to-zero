package likeherotozero;

import jakarta.persistence.*;

@Entity
public class Co2Emission {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String land;

    private int jahr;

    private double co2Wert;

    public Co2Emission() {}

    public Co2Emission(String land, int jahr, double co2Wert) {
        this.land = land;
        this.jahr = jahr;
        this.co2Wert = co2Wert;
    }

    public Long getId() {
        return id;
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
