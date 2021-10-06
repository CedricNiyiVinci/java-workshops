package domaine;


import static util.Util.*;


import exceptions.QuantiteNonAutoriseeException;
import util.Util;

import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

public class Prix {

    private final Promo typePromo;
    private final double valeurPromo;
    // Clé - Valeur : quantité - Prix
    private SortedMap<Integer, Double> mapDePrix = new TreeMap<Integer, Double>();
    //TODO Ajouter l'attribut pour garder les différents prix correspondant à une quantité minimale et l'initialiser


    public Prix() {
        typePromo = null;
        valeurPromo = 0;
    }

    public Prix(Promo promo, double valeurPromo) {
        checkObject(promo);
        checkPositiveOrZero(valeurPromo);
        this.typePromo = promo;
        this.valeurPromo = valeurPromo;
    }


    public Promo getTypePromo() {
        return typePromo;
    }

    public double getValeurPromo() {
        return valeurPromo;
    }

    /**
     * Cette méthode permet de définir le prix unitaire correspondant à une quantité minimale.
     * S'il existe déjà un prix correspondant à la quantité, il sera remplacé.
     *
     * @param quantiteMin
     * @param valeur      le prix unitaire à partir de cette quantité
     * @throws IllegalArgumentException en cas de quantité négative ou nulle ou en cas de valeur négative ou nulle
     */
    public void definirPrix(int quantiteMin, double valeur) {
        //D'abord on verifie si les parametres ne sont pas negatifs et cela grace a l'Interface Util
        Util.checkPositive(quantiteMin);
        Util.checkPositive(valeur);

        // modification ou definition du prix en fonction de la quantite associé
        mapDePrix.put(quantiteMin, valeur);
    }


    /**
     * Cette méthode renvoie le prix à appliquer selon la quantité achetée
     *
     * @param la quantité achetée
     * @return le prix unitaire pour cette quantité
     * @throws QuantiteNonAutoriseeException si la quantité est inférieure à la quantité minimale autorisée
     * @throws IllegalArgumentException      en cas de quantité négative ou nulle
     */
    public double getPrix(int quantite) throws QuantiteNonAutoriseeException {
        Util.checkPositive(quantite);
        double prixARenvoye =0;

        for (Map.Entry<Integer, Double> entry: mapDePrix.entrySet()) {
            if(quantite>= entry.getKey()){
                prixARenvoye = entry.getValue();
            }
        }
        //Si mon prix est encore ==0 a, je lance l'exception, c-a-d que je n'ai pas trouvé de quantite plus grande ou egale
        //qui pourrait etre autoriser

        if (prixARenvoye==0) throw new QuantiteNonAutoriseeException();
        return prixARenvoye;
    }


    @Override
    public String toString() {
        String detail = "";
        if (typePromo != null) detail += "Promo : " + typePromo + " - " + valeurPromo + "\n";

        for (Map.Entry<Integer, Double> entry: mapDePrix.entrySet()) {
            detail += entry.getValue() + " euros à partir de " + entry.getKey() + " unités\n";
        }
        //TODO Ajoutez les différents prix en passant à la ligne entre chaque prix. Format attendu :
        /*
         * 99.9 euros à partir de 1 unités
         * 89.9 euros à partir de 3 unités
         * 59.9 euros à partir de 5 unités
         */

        return detail;
    }


}
