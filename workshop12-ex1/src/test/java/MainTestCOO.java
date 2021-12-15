import marathon.Coureur;
import marathon.Marathon;
import marathon.Marathon.CheckPoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MainTestCOO {

	MarathonFactory factory = new MarathonFactoryImpl();

	Marathon bxl;
	Coureur coureur1;
	Coureur coureur2;
	Coureur coureur3;
	Coureur coureur0;

	@BeforeEach
	public void setUp() throws Exception {
		bxl = factory.getMarathon();
		bxl.setNom("Bruxelles");
		bxl.setJour(LocalDate.of(2022, 10, 7));

		Coureur coureur1 = this.factory.getCoureur();
		coureur1.setDossard("1");
		coureur1.setNom("Leleux");
		coureur1.setPrenom("Laurent");
		bxl.inscrire(coureur1);

		Coureur coureur2 = this.factory.getCoureur();
		coureur2.setDossard("2");
		coureur2.setNom("Baroni");
		coureur2.setPrenom("Raphaël");
		bxl.inscrire(coureur2);

		Coureur coureur3 = this.factory.getCoureur();
		coureur3.setDossard("3");
		coureur3.setNom("Ferneeuw");
		coureur3.setPrenom("Stéphanie");
		bxl.inscrire(coureur3);

		Coureur coureur0 = this.factory.getCoureur();
		coureur3.setDossard("0");
		coureur3.setNom("Lapierre");
		coureur3.setPrenom("Baptiste");
	}

	@Test
	public void testInscrire1() {
		Coureur coureur = this.factory.getCoureur();
		coureur.setDossard("1");
		coureur.setNom("Baroni");
		coureur.setPrenom("Raphaël");
		assertFalse(bxl.inscrire(coureur));
	}

	@Test
	public void testInscrire2() {
		Marathon marathon = factory.getMarathon();
		marathon.setNom("Bruxelles");
		marathon.setJour(LocalDate.of(2021, 10, 1));

		Coureur coureur = this.factory.getCoureur();
		coureur.setDossard("6");
		coureur.setNom("Baroni");
		coureur.setPrenom("Raphaël");

		assertFalse(marathon.inscrire(coureur));
	}

	@Test
	public void testAjouterCheck1() {
		assertTrue(bxl.ajouterCheck("1", CheckPoint.CHECK1, Duration.ofMillis(5000)));
	}

	@Test
	public void testAjouterCheck2() {
		assertTrue(bxl.ajouterCheck("1", CheckPoint.CHECK1, Duration.ofSeconds(1900)));

		assertTrue(bxl.ajouterCheck("1", CheckPoint.CHECK2, Duration.ofSeconds(3800)));
		assertTrue(bxl.ajouterCheck("1", CheckPoint.CHECK3, Duration.ofSeconds(6000)));
	}

	@Test
	public void testAjouterCheck3() {
		assertTrue(bxl.ajouterCheck("1", CheckPoint.CHECK1, Duration.ofSeconds(1900)));
		assertTrue(bxl.ajouterCheck("1", CheckPoint.CHECK2, Duration.ofSeconds(3800)));
		assertFalse(bxl.ajouterCheck("1", CheckPoint.CHECK1, Duration.ofSeconds(1900)));
	}

	@Test
	public void testAjouterCheck4() {
		assertTrue(bxl.ajouterCheck("1", CheckPoint.CHECK1, Duration.ofSeconds(1900)));

		assertTrue(bxl.ajouterCheck("1", CheckPoint.CHECK2, Duration.ofSeconds(3800)));
		assertTrue(bxl.ajouterCheck("1", CheckPoint.CHECK3, Duration.ofSeconds(6000)));
	}

	@Test
	public void testlesCoureursClasses1() {
		assertTrue(bxl.ajouterCheck("1", CheckPoint.CHECK1, Duration.ofSeconds(3200)));
		assertTrue(bxl.ajouterCheck("2", CheckPoint.CHECK1, Duration.ofSeconds(2800)));
		assertTrue(bxl.ajouterCheck("3", CheckPoint.CHECK1, Duration.ofSeconds(3000)));
		List<Coureur> coureurs = bxl.lesCoureursClasses(CheckPoint.CHECK1);
		assertEquals("2", coureurs.get(0).getDossard());
		assertEquals("3", coureurs.get(1).getDossard());
		assertEquals("1", coureurs.get(2).getDossard());
		assertEquals(3, coureurs.size());
	}

	@Test
	public void testlesCoureursClasses2() {
		assertTrue(bxl.ajouterCheck("1", CheckPoint.CHECK1, Duration.ofSeconds(3200)));
		assertTrue(bxl.ajouterCheck("2", CheckPoint.CHECK1, Duration.ofSeconds(2800)));
		assertTrue(bxl.ajouterCheck("3", CheckPoint.CHECK1, Duration.ofSeconds(3000)));

		assertTrue(bxl.ajouterCheck("1", CheckPoint.CHECK2, Duration.ofSeconds(6800)));
		List<Coureur> coureurs = bxl.lesCoureursClasses(CheckPoint.CHECK2);
		assertEquals("1", coureurs.get(0).getDossard());
		assertEquals(1, coureurs.size());
	}

}