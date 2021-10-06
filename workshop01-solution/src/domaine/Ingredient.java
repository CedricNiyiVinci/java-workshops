package domaine;

import util.Util;

import java.util.Objects;

public class Ingredient {
    private String nom;
    private double prix;

    /**
     * Create an Ingredient
     *
     * @param nom
     * @param prix
     * @throws IllegalArgumentException if a parameter is not specified or the price is negative
     */
    public Ingredient(String nom, double prix) {
        Util.checkString(nom);
        Util.checkPositive(prix);
        this.nom = nom;
        this.prix = prix;
    }

    /**
     * @return nom of ingredient
     */
    public String getNom() {
        return nom;
    }


    /**
     * @return prix of ingredient
     */
    public double getPrix() {
        return prix;
    }

    /**
     * @return hash code : 2 objects that are the same return the same hash code
     */

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }

    /**
     * @param obj : object to be compared for equality
     * @return true if the objects are the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return nom.equals(that.nom);
    }

}
