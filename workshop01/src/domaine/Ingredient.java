package domaine;

import java.util.Objects;

public class Ingredient {

    private String nom;
    private double prix;

    public Ingredient(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient ingrdient = (Ingredient) o;
        return Objects.equals(nom, ingrdient.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }
}
