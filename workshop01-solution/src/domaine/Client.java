package domaine;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import exceptions.NoCommandeEnCoursException;
import util.Util;


public class Client implements Iterable<Commande> {
	private int numero;
	private String nom;
	private String prenom;
	private String tel;
	/**
	 * La commande que le client est en train de passer maintenant. Si aucune
	 * commande, null.
	 */
	private Commande commandeEnCours;
	/**
	 * La liste de toutes les commandes a passées.
	 */
	private List<Commande> commandesPassees = new ArrayList<>();

	
	public Client(int numero, String nom, String prenom, String tel) {
		Util.checkString(nom);
		Util.checkString(prenom);
		Util.checkString(tel);
		this.numero = numero;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
	}
	
	public int getNumero() {
		return numero;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getTel() {
		return tel;
	}	

	/**
	 * @return repr�sentation textuelle du client
	 */
	@Override
	public String toString() {
		return "Client [numero=" + numero + ", nom=" + nom + ", prenom=" + prenom + ", telephone=" + tel + "]";
	}

	/**
	 * renvoie la commande en cours du client. Si aucune commande en cours, elle
	 * renvoie null.
	 *
	 * @return La commande en cours du client. null si aucune en cours.
	 */
	public Commande getCommandeEnCours() {
		return commandeEnCours;
	}

	/**
	 * ajoute une commande en cours au client s'il n'en poss�de pas. Le client de la
	 * commande doit correspondre � celui � qui la commande est ajout�e (this).
	 *
	 * @param commande Commande qu'on veut ajouter � ce client.
	 * @return true si la commande a pu devenir la commande en cours du client.
	 *         false si this ne correspondont pas au client de la commande ou si le
	 *         client a d�j� une commande en cours.
	 */
	public boolean ajouterCommandeEnCours(Commande commande) {
		if (commande == null)
			return false;
		if (this.commandeEnCours != null)
			return false;
		if (commande.getClient() != this)
			return false;
		this.commandeEnCours = commande;
		return true;
	}

	/**
	 * cloture la commande en cours du client. La commande en cours du client est
	 * ajout�e aux commandes pass�es. Le client n'a plus de commande en cours.
	 *
	 * @throws NoCommandeEnCoursException Exception lanc�e si la commande en cours
	 *                                    du client est nulle.
	 */
	public void cloturerCommandeEnCours() throws NoCommandeEnCoursException {
		if (this.commandeEnCours == null)
			throw new NoCommandeEnCoursException("Le client ne poss�de pas de commande en cours.");
		this.commandesPassees.add(commandeEnCours);
		commandeEnCours = null;
	}

	/**
	 * renvoie la valeur de hashing de l'objet. 2 objets �gaux renvoient la m�me
	 * valeur de hashing.
	 *
	 * @return la valeur de hashing de l'objet
	 */
	/*
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
		return result;
	}*/


	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}
	/**
	 * compare l'�galit� de deux clients. Deux clients sont �gaux s'ils ont le m�me
	 * num�ro.
	 *
	 * @param obj l'objet qui doit �tre compar� pour �galit�.
	 * @return true si les objets sont les m�mes (m�me num�ro).
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Client commandes = (Client) o;
		return numero == commandes.numero;
	}

	/**
	 * @return l'iterator des commandes pass�es
	 */

	@Override
	public Iterator<Commande> iterator() {
		return commandesPassees.iterator();
	}




}
