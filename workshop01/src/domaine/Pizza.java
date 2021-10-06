package domaine;

import java.util.List;
import java.util.Objects;

public class Pizza implements Iterable<Ingredient>{


    private String titre;
    private String description;
    public static final double PRIX_BASE=4;
    private List<Ingredient> ingredients;

    public Pizza(String titre, String description, List<Ingredient> ingredients) {
        this.titre = titre;
        this.description = description;
        this.ingredients = ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return Objects.equals(titre, pizza.titre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titre);
    }

    public boolean ajouter(Ingredient ingredient) {
        if(ingredients.contains(ingredient)) return false;
        ingredients.add(ingredient);
        return true;
    }

    public boolean supprimer(Ingredient ingredient){
        if(!ingredients.contains(ingredient)) return false;
        ingredients.remove(ingredients.indexOf(ingredient));
        return true;
    }

}
