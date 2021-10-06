package cuisine;

import util.Util;

import java.util.Objects;

public class IngredientQuantifie {

    private Ingredient ingredient;
    private double quantite;
    private Unite unite;

    public IngredientQuantifie(Ingredient ingredient, double quantite, Unite unite) {
        this.ingredient = ingredient;
        setQuantite(quantite);
        this.unite = unite;
    }

    public void setQuantite(double quantite) {
        Util.checkPositive(quantite);
        this.quantite = quantite;
    }

    public void setUnite(Unite unite) {
        this.unite = unite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IngredientQuantifie that = (IngredientQuantifie) o;
        return Objects.equals(ingredient, that.ingredient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredient);
    }

    public String toString(){
        return quantite + " "+ unite + ingredient.getNom();
    }
}
