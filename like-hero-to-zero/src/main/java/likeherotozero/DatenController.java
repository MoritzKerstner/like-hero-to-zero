package likeherotozero;

import java.io.Serializable;
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
	private static final long serialVersionUID = 1L;

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("co2_emissionenPU");
	private EntityManager em;

	private String neuesLand;
	private int neuesJahr;
	private double neuerCo2Wert;

	public DatenController() {
		this.em = emf.createEntityManager(); // EntityManager einmalig erstellen
	}

	public void neueEmissionHinzufuegen() {
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			Co2Emission emission = new Co2Emission(neuesLand, neuesJahr, neuerCo2Wert);
			em.persist(emission);
			t.commit();
		} catch (Exception e) {
			if (t.isActive()) {
				t.rollback();
			}
			e.printStackTrace();
		}

		// Nach dem Speichern Felder zurücksetzen
		neuesLand = "";
		neuesJahr = 0;
		neuerCo2Wert = 0.0;
	}

	public List<Co2Emission> getAlleEmissionen() {
		return em.createQuery("SELECT e FROM Co2Emission e", Co2Emission.class).getResultList();
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

	// Beim Beenden der Session EntityManager schließen
	public void close() {
		if (em != null && em.isOpen()) {
			em.close();
		}
	}
}
