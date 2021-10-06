package domaine;

import java.util.ArrayList;

/**
 * La classe PizzaComposee repr�sente la pizza compos�e. Elle connait son prix
 * calcul� lors de sa cr�ation avec une remise.
 *
 * @author lecem
 */
public class PizzaComposee extends Pizza {
    /**
     * le prix de la pizza compos�e
     */
    private double prix = 0;
    /**
     * la remise effectu�e par rapport aux co�ts des ingr�dients qui la composent.
     */
    private static int REMISE = 15;

    /**
     * Cr�e une pizza compos�e en calculant son prix sur base de celui des
     * ingr�dients qui la composent en tennat compte de la remise � effectuer.
     *
     * @param titre       le titre de la pizza compos�e
     * @param description la description de la pizza compos�e
     * @param ingredients les ingr�dients de la pizza compos�e
     * @throws IllegalArgumentException Exception lanc�e si l'un des param�tres
     *                                  n'est pas sp�cifi� ou vide.
     */
    public PizzaComposee(String titre, String description, ArrayList<Ingredient> ingredients) {
        super(titre, description, ingredients);
        prix += Math.ceil(super.calculerPrix() * (100 - REMISE) / 100);
    }

    /**
     * calcule le prix de la pizza compos�e. Ce prix est calcul� une seule fois lors
     * de la cr�ation de la pizza compos�e.
     *
     * @return le prix de la pizza compos�e
     */
    @Override
    public double calculerPrix() {
        return prix;
    }

    /**
     * @throws UnsupportedOperationException Exception lanc�e car l'op�ration
     *                                       n'est pas permise sur la classe
     *                                       pizza compos�e. Il n'est pas
     *                                       possible d'ajouter un ingr�dient
     *                                       d'une pizza compos�e.
     */
    @Override
    public boolean ajouter(Ingredient ingredient) {
        throw new UnsupportedOperationException();
    }

    /**
     * @throws UnsupportedOperationException Exception lanc�e car l'op�ration
     *                                       n'est pas permise sur la classe
     *                                       pizza compos�e. Il n'est pas
     *                                       possible de supprimer un ingr�dient
     *                                       d'une pizza compos�e.
     */
    @Override
    public boolean supprimer(Ingredient ingredient) {
        throw new UnsupportedOperationException();
    }

}
