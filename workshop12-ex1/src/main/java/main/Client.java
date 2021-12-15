package main;

import marathon.Coureur;
import marathon.Marathon;

import java.time.LocalDate;

public class Client {

	public void startMarathon() {
		Marathon bxl = new Marathon("Bruxelles", LocalDate.of(2022, 10, 7));
		Coureur coureur1 = new Coureur("1", "Leleux", "Laurent");
		bxl.inscrire(coureur1);
		Coureur coureur2 = new Coureur("2", "Baroni", "Raphaël");
		bxl.inscrire(coureur2);
		Coureur coureur3 = new Coureur("3", "Ferneeuw", "Stéphanie");
		bxl.inscrire(coureur3);
		// TODO pour tester
		/*
		 * bxl.ajouterCheck("1", CheckPoint.CHECK0, Duration.ofSeconds(0));
		 * bxl.ajouterCheck("2", CheckPoint.CHECK0, Duration.ofSeconds(0));
		 * bxl.ajouterCheck("3", CheckPoint.CHECK0, Duration.ofSeconds(100));
		 * bxl.ajouterCheck("1", CheckPoint.CHECK1, Duration.ofSeconds(3200));
		 * bxl.ajouterCheck("2", CheckPoint.CHECK1, Duration.ofSeconds(2800));
		 * bxl.ajouterCheck("3", CheckPoint.CHECK1, Duration.ofSeconds(3000));
		 * bxl.ajouterCheck("1", CheckPoint.CHECK2, Duration.ofSeconds(6800));
		 * bxl.ajouterCheck("3", CheckPoint.CHECK3, Duration.ofSeconds(10000));
		 */

		System.out.println(bxl);
		bxl.forEach(System.out::println);
	}

}
