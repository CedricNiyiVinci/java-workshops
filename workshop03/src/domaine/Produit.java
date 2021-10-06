package domaine;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;
import java.util.Map.Entry;

import util.Util;
import exceptions.DateDejaPresenteException;
import exceptions.PrixNonDisponibleException;

public class Produit {

    private final String nom;
    private final String rayon;
    private final String marque;

    //TODO initialiser histriquePrix de sorte que le tri se fasse par ordre décroissant de date
    private SortedMap<LocalDate, Prix> historiquePrix = new TreeMap<LocalDate, Prix>(Comparator.reverseOrder());

    public Produit(String nom, String marque, String rayon) {
        Util.checkString(nom);
        Util.checkString(marque);
        Util.checkString(rayon);
        this.nom = nom;
        this.marque = marque;
        this.rayon = rayon;
    }

    public String getMarque() {
        return marque;
    }

    public String getNom() {
        return nom;
    }

    public String getRayon() {
        return rayon;
    }

    /**
     * ajoute un prix dans l'historique si la date n'est pas déjà présente
     *
     * @param date la date à partir duquel les prix s'appliquent
     * @param prix
     * @throws DateDejaPresenteException si la date est déjà présente dans l'historique
     * @throws IllegalArgumentException  en cas de paramètre invalide
     */
    public void ajouterPrix(LocalDate date, Prix prix) throws DateDejaPresenteException {
        //TODO Complétez la méthode
        Util.checkObject(date);
        Util.checkObject(prix);

        if(historiquePrix.containsKey(date)) throw new DateDejaPresenteException();

        historiquePrix.put(date, prix);
    }

    /**
     * Renvoie le prix appliqué à une date donnée
     *
     * @param date la date pour laquelle il faut retrouver le prix
     * @return le prix
     * @throws PrixNonDisponibleException s'il n'y a pas de prix disponible pour cette date
     * @throws IllegalArgumentException   en cas de paramètre invalide
     */
    public Prix getPrix(LocalDate date) throws PrixNonDisponibleException {
        //TODO Complétez la méthode
        Util.checkObject(date);
        Prix prixARenvoye = null;
        for (Map.Entry<LocalDate, Prix> entry: historiquePrix.entrySet()) {
            if(date.isAfter(entry.getKey())){
                return entry.getValue();
            }
        }
        throw new PrixNonDisponibleException();
    }

    @Override
    public String toString() {
        String detail = "Nom : " + nom + "\nMarque : " + marque + "\nRayon : " + rayon + "\nHistorique des prix :";
        DateTimeFormatter formater = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        for (Entry<LocalDate, Prix> entry : historiquePrix.entrySet()) {
            detail += "\n" + formater.format(entry.getKey()) + " :\n" + entry.getValue();
        }

        return detail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produit produit = (Produit) o;
        return Objects.equals(nom, produit.nom) && Objects.equals(rayon, produit.rayon) && Objects.equals(marque, produit.marque);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, rayon, marque);
    }

    //TODO Ajoutez les méthodes qui permettent de définir l'unicité sur base du nom, de la marque et du rayon
    // Equals et Hashcode ajoutee!!!


}
