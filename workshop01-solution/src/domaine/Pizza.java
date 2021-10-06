package domaine;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import util.Util;

/**
 * La classe Pizza repr�sente la pizza. Elle connait ses ingr�dients.
 *
 * @author lecem
 */

public abstract class Pizza implements Iterable<Ingredient> {
    /**
     * le prix de base des pizzas
     */
    public static final double PRIX_BASE = 4.0;
    /**
     * le titre de cette pizza
     */
    private String titre;
    /**
     * la description de cette pizza
     */
    private String description;
    /**
     * la liste des ingr�dients de cette pizza.
     */
    private ArrayList<Ingredient> ingredients;

    /**
     * Cr�e une pizza sans ingr�dient
     *
     * @param titre       le titre de la pizza
     * @param description la description de la pizza
     * @throws IllegalArgumentException Exception lanc�e si l'un des param�tres
     *                                  n'est pas sp�cifi� ou vide.
     */
    public Pizza(String titre, String description) {
        Util.checkString(titre);
        Util.checkString(description);
        this.titre = titre;
        this.description = description;
        this.ingredients = new ArrayList<Ingredient>();
    }

    /**
     * Cr�e une pizza
     *
     * @param titre       le titre de la pizza
     * @param description la description de la pizza
     * @param ingredients les ingr�dients de la pizza
     * @throws IllegalArgumentException Exception lanc�e dans un des cas suivants
     *                                  un des param�tres de type cha�ne de caract�res n'est pas sp�cifi� ou vide.
     *                                  la liste des ingr�dients n'est pas sp�cifi�e ou contient deux fois le m�me ingr�dient.
     */
    public Pizza(String titre, String description, List<Ingredient> ingredients) {
        this(titre, description);
        Util.checkObject(ingredients);
        for (Ingredient i : ingredients) {
            if (this.ingredients.contains(i)) throw new IllegalArgumentException();
            this.ingredients.add(i);
        }
    }


    /**
     * calcule le prix de la pizza en se basant sur le prix des ingr�dients cummul�s
     * � celui du prix PRIX_BASE.
     *
     * @return le prix calcul� de la pizza
     */
    public double calculerPrix() {
        double tot = PRIX_BASE;
        for (Ingredient ingredient : ingredients) {
            tot += ingredient.getPrix();
        }

        return tot;
    }

    /**
     * le titre de la pizza
     *
     * @return le titre de la pizza
     */
    public String getTitre() {
        return titre;
    }

    /**
     * la description de la pizza
     *
     * @return la desciption de la pizza
     */

    public String getDescription() {
        return description;
    }

    /**
     * convertit la pizza sous forme de String : <br>Pizza [titre= <em>son titre</em>,
     * description = <em>sa description</em>]
     *
     * @return repr�sentation textuelle de la pizza
     */
    @Override
    public String toString() {
        return "Pizza [titre=" + titre + ", description=" + description + "]";
    }

    /**
     * @return l'iterator des ingr�dients de la pizza
     */
    @Override
    public Iterator<Ingredient> iterator() {
        return ingredients.iterator();
    }

    /**
     * ajoute un ingr�dient � la pizza si cet ingr�dient n'en fait pas encore partie.
     *
     * @param ingredient l'ingr�dient � ajouter
     * @return true si l'ingr�dient a �t� ajout�
     */

    public boolean ajouter(Ingredient ingredient) {
        Util.checkObject(ingredient);
        if (ingredients.contains(ingredient))
            return false;
        return this.ingredients.add(ingredient);
    }

    /**
     * supprime un ingr�dient � la pizza si cet ingr�dient en fait partie.
     *
     * @param ingredient l'ingr�dient � supprimer
     * @return true si l'ingr�dient a �t� supprim�
     */
    public boolean supprimer(Ingredient ingredient) {
        Util.checkObject(ingredient);
        return this.ingredients.remove(ingredient);
    }

    /**
     * renvoie la valeur de hashing de l'objet. 2 objets �gaux renvoient la m�me
     * valeur de hashing.
     *
     * @return la valeur de hashing de l'objet
     */

    @Override
    public int hashCode() {
        return Objects.hash(titre);
    }

    /**
     * Compare l'�galit� de deux pizzas. Deux pizzas sont �gales si leurs titres le
     * sont.
     *
     * @param obj l'objet qui doit �tre compar� pour �galit�.
     * @return true si les objets sont les m�mes.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza that = (Pizza) o;
        return titre.equals(that.titre);
    }


}
