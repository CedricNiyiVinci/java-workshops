package tests;

import static casUtilisation.Ingredients.*;

import casUtilisation.GestionPizzeria;
import domaine.Client;
import domaine.Commande;
import exceptions.NoCommandeEnCoursException;

public class Main {
    private static GestionPizzeria pizzeria = new GestionPizzeria();

    public static void main(String[] args) {
        if (args.length > 0)
            System.out.println("arg[0] : " + args[0] + args[1] + args[2] + args[3] + " length:" + args.length);
        Client emmeline = pizzeria.enregistrerClient("Leconte", "Emmeline", "0488/98.23.85");
        Client stephanie = pizzeria.enregistrerClient("Ferneeuw", "Stéphanie", "0475/51.30.80");
        Client johny = pizzeria.enregistrerClient("Dub", "Johny", "066/66.66.66");


        Commande commandeEmmeline = pizzeria.creerCommande(emmeline);
        try {
            pizzeria.ajouterALaCommande(emmeline, pizzeria.p_duchef, 2);

            pizzeria.creerPizzaComposable(emmeline, 2, aubergines, tomate, gogonzola);
            System.out.println(commandeEmmeline);

            pizzeria.validerCommande(emmeline);
            System.out.println(commandeEmmeline);
            System.out.println(commandeEmmeline.detailler());

            Commande commandeStephanie = pizzeria.creerCommande(stephanie);
            pizzeria.ajouterALaCommande(stephanie, pizzeria.p_margarita, 1);
            pizzeria.ajouterALaCommande(stephanie, pizzeria.p_margarita, 1);
            pizzeria.ajouterALaCommande(stephanie, pizzeria.p_mariniere, 3);
            System.out.println(commandeStephanie);
            System.out.println(commandeStephanie.detailler());

            commandeEmmeline = pizzeria.creerCommande(emmeline);
            pizzeria.creerPizzaComposable(emmeline, 3, jambon, tomate, olives, mozza);
            System.out.println(commandeEmmeline);

            Commande commandeJohny = pizzeria.creerCommande(johny);
            pizzeria.ajouterALaCommande(johny, pizzeria.p_margarita, 5);
            pizzeria.ajouterALaCommande(johny, pizzeria.p_4fromages, 6);
            pizzeria.retirerDeLaCommande(johny, pizzeria.p_4fromages, 2);
            pizzeria.ajouterALaCommande(johny, pizzeria.p_mariniere, 3);
            System.out.println(commandeJohny);
            System.out.println(commandeJohny.detailler());
        } catch (NoCommandeEnCoursException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
