package domaine;

import java.util.List;

public class PizzaComposee extends Pizza{

    private double prix;
    private static final int REMISE=15;

    public PizzaComposee(String titre, String description, List<Ingredient> listeIngredients) {
        super(titre, description, listeIngredients);
        this.prix = Math.ceil(1.15*(PRIX_BASE + prixDeLaPizza(listeIngredients)));
    }

    public double prixDeLaPizza(List<Ingredient> listeIngredients){
        double prixDeLaPizza = 0;
        for (int i = 0; i <listeIngredients.size(); i++) {
            prixDeLaPizza += listeIngredients.get(i).getPrix();
        }
        return prixDeLaPizza;
    }
}
