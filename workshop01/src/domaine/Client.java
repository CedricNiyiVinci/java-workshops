package domaine;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import exceptions.NoCommandeEnCoursException;
import util.Util;

public class Client implements Iterable<Commande> {
	private int numero;
	private String nom;
	private String prenom;
	private String tel;

	
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
	 * @return représentation textuelle du client
	 */
	@Override
	public String toString() {
		return "Client [numero=" + numero + ", nom=" + nom + ", prenom=" + prenom + ", telephone=" + tel + "]";
	}
	
	
	
}
