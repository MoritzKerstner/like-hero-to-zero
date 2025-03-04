package likeherotozero;
import java.io.Serializable;
import java.text.ParseException;
import java.util.List;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped; 

@Named
@SessionScoped
public class DatenController implements Serializable {
	private DatenVerwalter datenVerwalter;
	private String neuesLand;
	private int neuesJahr;
	private double neuerCo2Wert;

	public DatenController() {
		datenVerwalter = new DatenVerwalter();
	}

	public void neueEmissionHinzufuegen() {
		Co2Emission emission = new Co2Emission(neuesLand, neuesJahr, neuerCo2Wert);
		datenVerwalter.emissionHinzufuegen(emission);
		neuesLand = "";
		neuesJahr = 0;
		neuerCo2Wert = 0.0;
	}

	public List<Co2Emission> getAlleEmissionen() {
		return datenVerwalter.getAlleEmissionen();
	}

	// Getter und Setter
	public String getNeuesLand() {
		return neuesLand;
	}

	public void setNeuesLand(String neuesLand) {
		this.neuesLand = neuesLand;
	}

	public int getNeuesJahr() {
		return neuesJahr;
	}

	public void setNeuesJahr(int neuesJahr) {
		this.neuesJahr = neuesJahr;
	}

	public double getNeuerCo2Wert() {
		return neuerCo2Wert;
	}

	public void setNeuerCo2Wert(double neuerCo2Wert) {
		this.neuerCo2Wert = neuerCo2Wert;
	}
}