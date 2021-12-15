import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import marathon.Coureur;
import marathon.Marathon;
import marathon.Marathon.CheckPoint;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainTest {
	Marathon bxl;
	Coureur coureur1;
	Coureur coureur2;
	Coureur coureur3;
	Coureur coureur0;

	@BeforeEach
	public void setUp() throws Exception {
		bxl = new Marathon("Bruxelles", LocalDate.of(2022, 10, 7));
		coureur1 = new Coureur("1", "Leleux", "Laurent");
		bxl.inscrire(coureur1);
		coureur2 = new Coureur("2", "Baroni", "Raphaël");
		bxl.inscrire(coureur2);
		coureur3 = new Coureur("3", "Ferneeuw", "Stéphanie");
		bxl.inscrire(coureur3);
		coureur0 = new Coureur("0", "Lapierre", "Baptiste");
	}

	@Test
	public void testInscrire1() {
		assertFalse(bxl.inscrire(new Coureur("1", "Baroni", "Raphaël")));
	}

	@Test
	public void testInscrire2() {
		assertFalse(
				new Marathon("Bruxelles", LocalDate.of(2021, 10, 1)).inscrire(new Coureur("6", "Baroni", "Raphaël")));
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