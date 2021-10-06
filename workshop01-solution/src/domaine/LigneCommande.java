package domaine;

import util.Util;

/**
 * La classe LigneCOmmande représente une ligne de commande. Elle connait la
 * pizza commandée, la quantité commandée de cette pizza et retient son prix
 * unitaire au moment de la commande.
 *
 * @author lecem
 */
public class LigneCommande {
    /**
     * la quantité de pizza commandée
     */
    private int quantite;
    /**
     * la pizza commandée
     */
    private Pizza pizza;
    /**
     * le prix unitaire de la pizza command�e
     */
    private double prixUnitaire;

    /**
     * Crée une ligne de commande pour la pizza passée en paramètre et dans la
     * quantit� pass�e en param�tre.
     *
     * @param quantite la quantit� de pizza command�e
     * @param pizza    la pizza command�e
     */
    public LigneCommande(int quantite, Pizza pizza) {
        Util.checkPositive(quantite);
        Util.checkObject(pizza);
        this.quantite = quantite;
        this.pizza = pizza;
        this.prixUnitaire = pizza.calculerPrix();
    }

    /**
     * Convertit la ligne de commande sous forme de String: <br>
     * LigneCommande [ <em> la quantit� command�e</em> <em> le titre de la pizza
     * command�e</em> � <em> le prix unitaire de la pizza</em> �]
     *
     * @return repr�sentation textuelle de la ligne de commande
     */
    @Override
    public String toString() {
        return "LigneCommande [" + quantite + " " + pizza.getTitre() + "  � " + prixUnitaire + "�]";
    }

    /**
     * calcule le prix total de la ligne de commande en consid�rant les quantit�s
     * command�es.
     *
     * @return le prix total de la ligne de commande
     */

    public double calculerPrixTotal() {
        return quantite * prixUnitaire;
    }

    /**
     * renvoie la quantit� de la pizza de la ligne de commande
     *
     * @return la pizza
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * renvoie la pizza de la ligne de commande
     *
     * @return la pizza
     */
    public Pizza getPizza() {
        return pizza;
    }

    /**
     * le prix unitaire de la pizza de la ligne de commande
     *
     * @return le prix unitaire de la pizza
     */
    public double getPrixUnitaire() {
        return prixUnitaire;
    }


    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
