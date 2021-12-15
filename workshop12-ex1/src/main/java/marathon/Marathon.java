package marathon;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Marathon implements Iterable<Coureur> {

	private LocalDate jour;
	private String nom;
	// Collection sans doublon ET ordre de tri
	SortedSet<Coureur> listeDeParticipant = new TreeSet<Coureur>() ;// Il ne faut rien donné en parametre


	public Marathon(String nom, LocalDate localDate) {
		this.jour = localDate;
		this.nom = nom;
	}
	
	public LocalDate getJour() {
		return jour;
	}

	public void setJour(LocalDate jour) {
		this.jour = jour;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	/*
	 * Checkpoint doit devenir un énuméré comme expliqué dans l'énoncé.
	 */
	public enum CheckPoint {
		CHECK0(0), CHECK1(10), CHECK2(20), CHECK3(30), CHECK4(40),
		CHECK5(42.195);

		private double distance;

		CheckPoint(double distance) {
			this.distance = distance;
		}
	}

	/*
	 * La méthode permet l'inscription d'un coureur jusqu'au jour précédent la
	 * course. Elle renvoie false si l'inscription n'a pas pu etre effectuée pour
	 * cette raison ou si le coureur est déjà inscrit.
	 */
	public boolean inscrire(Coureur coureur) {
		if(listeDeParticipant.contains(coureur)) return false;
		if(!LocalDate.now().isBefore(this.jour)) return false;

		listeDeParticipant.add(coureur);
		return true;
	}

	/*
	 * La méthode ajoute le temps de passage au checkpoint passé en paramètre par le
	 * coureur dont le dossard est fourni en paramètre. Elle renvoie true si le
	 * temps a bien été ajouté. Si le dossard n'appartient à aucun coureur, elle
	 * renvoie false.
	 */
	public boolean ajouterCheck(String dossard, CheckPoint checkPoint, Duration duration) {
		Coureur c = listeDeParticipant.stream().filter(coureur -> coureur.getDossard().equals(dossard)).findAny().orElse(null);
		if(c== null) return false;
		c.ajouterCheck(checkPoint,duration);
		return true;
	}

	/*
	 * La méthode renvoie la liste des coureurs classés par temps de passage au
	 * checkpoint fourni en paramètre. Si un coureur n'est pas passé par le checkpoint
	 * en paramètre, il ne doit figurer dans la liste. Cette méthode doit s'écrire
	 * avec une stream (1 seule instruction).
	 */
	public List<Coureur> lesCoureursClasses(CheckPoint checkPoint) {
		return null;
	}

	@Override
	public String toString() {
		return "Marathon de " + this.nom + "(" + this.jour.format(DateTimeFormatter.ISO_LOCAL_DATE) + ")";
	}

	/*
	 * La méthode renvoie un iterator des coureurs du marathon.
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<Coureur> iterator() {
		return null;
	}
}
