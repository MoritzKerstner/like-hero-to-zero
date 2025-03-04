package likeherotozero;

import java.util.ArrayList;
import java.util.List;

public class DatenVerwalter {
	private List<Co2Emission> emissionsDaten;

	public DatenVerwalter(List<Co2Emission> emissionsDaten) {
		super();
		emissionsDaten = new ArrayList<>();
	}

	public DatenVerwalter() {
		// WICHTIG: Liste initialisieren, um NullPointerException zu vermeiden
		emissionsDaten = new ArrayList<>();
	}

	public void emissionHinzufuegen(Co2Emission emission) {
	    emissionsDaten.add(emission);
	    System.out.println("Neue Emission gespeichert: " + emission.getLand() + ", " + emission.getJahr() + ", " + emission.getCo2Wert());
	}


	public List<Co2Emission> getAlleEmissionen() {
		return emissionsDaten;
	}

	public List<Co2Emission> getEmissionsDaten() {
		return emissionsDaten;
	}

	public void setEmissionsDaten(List<Co2Emission> emissionsDaten) {
		this.emissionsDaten = emissionsDaten;
	}
	
}
