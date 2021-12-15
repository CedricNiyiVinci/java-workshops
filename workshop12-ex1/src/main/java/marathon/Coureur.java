package marathon;

import java.time.Duration;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import marathon.Marathon.CheckPoint;

public class Coureur implements Comparable<Coureur>{
	private String dossard; //Un coureur a un dossard
	private String nom;
	private String prenom;
	private SortedMap<Marathon.CheckPoint, Duration> tempsMarathon = new TreeMap<Marathon.CheckPoint, Duration>();

	public Coureur(String dossard, String nom, String prenom) {
		super();
		this.dossard = dossard;
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getDossard() {
		return dossard;
	}

	public void setDossard(String dossard) {
		this.dossard = dossard;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Duration getDuration(CheckPoint checkPoint) {
		return null;
	}

	/*
	 * La méthode ajoute la durée pour le checkpoint fourni s'il n'y a pas déjà de
	 * durée pour ce checkpoint et renvoie true. Elle renvoie false si le checkpoint
	 * possède déjà une durée. Attention de conserver ses informations comme des
	 * attributs.
	 */
	public boolean ajouterCheck(CheckPoint checkPoint, Duration duration) {
		if(tempsMarathon.containsKey(checkPoint)) return false;
		tempsMarathon.put(checkPoint, duration);
		return true;
	}

	@Override
	public String toString() {
		String ret = "";
		
		//TODO compléter la ligne ci-dessous
		
		Set<CheckPoint> set = null;
		for (CheckPoint iterable_element : set) {
		
			//TODO compléter la ligne ci-dessous
			
			Duration duration = null;
			
			String hms = String.format("%d:%02d:%02d", duration.toHours() % 24, duration.toMinutes() % 60,
					duration.getSeconds() % 60);
			ret += "\t " + iterable_element + " - " + hms + "\n";
		}
		return dossard + " : " + prenom + " " + nom + "\n" + ret;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Coureur coureur = (Coureur) o;
		return Objects.equals(dossard, coureur.dossard);
	}

	@Override
	public int hashCode() {
		return Objects.hash(dossard);
	}

	@Override
	public int compareTo(Coureur c) {
		return this.dossard.compareTo(c.dossard);
	}


}
