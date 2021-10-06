package strings;

import java.util.Arrays;
import java.util.List;

public class TestStrings {

    private static List<String> mots = Arrays.asList(
            "contre", "imporsteur", "hamster", "montagne", "feuilleter", "laine", "demander", "lame", "profondeur",
            "suffrage", "pyramide", "verre", "imitateur", "couronne", "conseils", "découvrir", "ciboulette", "ruisseau",
            "allusion", "blouse", "rapine", "vue", "timbres", "bol", "spectre", "gestuel", "coussin"
    );

    public static void main(String[] args) {
        System.out.println("1. Afficher chaque mot de la liste");
        afficherTousLesMots();
        System.out.println("\n2.  Nouvelle liste de String dans laquelle on a ajoute \"- \" au début de chaque mot");
        System.out.println(ajouterTiret());
        System.out.println("\n3. Placer tous les mots dans un tableau de String");
        System.out.print("{ ");
        for (String s : toArray()) System.out.print(s + " ");
        System.out.println("}");
        System.out.println("\n4. Liste de String de longueur paire triée par ordre anti-alphabétique");
        System.out.println(antiAlphatetiqueLongueursPaires());
        System.out.println("\n5. String contenant tous les mots de longueur inférieure ou égale à 5, séparés par un espace, et en majuscule");
        System.out.println(uneSeuleStringFiltreeMaj());
        System.out.println("\n6. Premier mot de la liste de longueur égale 8, et qui contient 'i', en majuscule");
        System.out.println(premierMotDeLongueurContenant(8, 'i'));
        System.out.println("\n7.a String qui contient la concaténation de tous les mots du stream - avec Map");
        System.out.println(concatenationAvecMap());
        System.out.println("\n7.b String qui contient la concaténation de tous les mots du stream - sans Map");
        System.out.println(contatenationSansMap());
        System.out.println("\n8. Nombre de mots qui se terminent par le caractère 's'");
        System.out.println(nombreDeMotSeTerminantParS());
        System.out.println("\n9. Nombre total d'occurences de 'e'");
        System.out.println(nombreTotalOccurencesE());

    }

    /**
     * cf. point 1.
     */
    private static void afficherTousLesMots() {
        //TODO (effectuez un print)
    }

    /**
     * cf. point 2.
     */
    private static List<String> ajouterTiret() {
        //TODO
        return null;
    }

    /**
     * cf. point 3
     */
    private static String[] toArray() {
        //TODO
        return null;
    }

    /**
     * cf. point 4
     */
    private static List<String> antiAlphatetiqueLongueursPaires() {
        //TODO
        return null;
    }

    /**
     * cf. point 5
     */
    private static String uneSeuleStringFiltreeMaj() {
        //TODO
        return "";
    }

    /**
     * cf. point 6
     */
    private static String premierMotDeLongueurContenant(int longueur, char c) {
        //TODO
        return "";
    }

    /**
     * cf. point 7
     */
    private static String concatenationAvecMap() {
        //TODO
        return "";
    }

    /**
     * cf. point 7
     */
    private static String contatenationSansMap() {
        //TODO
        return "";
    }

    /**
     * cf. point 8
     */
    private static long nombreDeMotSeTerminantParS() {
        //TODO
        return 0;
    }

    /**
     * cf. point 9
     */
    private static int occurrences(char c, String s) {
        //TODO: utiliser la méthode chars() des String qui retourne un IntStream contenant les caractères
        //      de la String l'utiliser pour compter les occurrences.
        return 0;
    }

    /**
     * cf. point 9
     */
    private static int nombreTotalOccurencesE() {
        //TODO : utiliser occurrences() avec le char 'e'
        return 0;
    }

}
