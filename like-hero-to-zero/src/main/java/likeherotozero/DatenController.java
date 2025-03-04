package likeherotozero;
import java.io.Serializable;
import java.text.ParseException;
import java.util.List;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
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
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("co2_emissionenPU");
	    EntityManager em = emf.createEntityManager();
	    
	    EntityTransaction t = em.getTransaction();
	    try {
	        t.begin();
	        Co2Emission emission = new Co2Emission(neuesLand, neuesJahr, neuerCo2Wert);
	        em.persist(emission);  // Speichert die Emission in der Datenbank
	        t.commit();
	    } catch (Exception e) {
	        if (t.isActive()) {
	            t.rollback(); // Falls ein Fehler auftritt, wird die Transaktion zurückgesetzt
	        }
	        e.printStackTrace();
	    } finally {
	        em.close();
	        emf.close();
	    }

	    // Nach dem Speichern Felder zurücksetzen
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