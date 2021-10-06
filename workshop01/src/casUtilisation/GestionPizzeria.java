package casUtilisation;

import static casUtilisation.Ingredients.*;

import java.util.ArrayList;
import java.util.List;

import domaine.Client;
import domaine.Commande;
import domaine.Ingredient;
import domaine.Pizza;
import domaine.PizzaComposable;
import domaine.PizzaComposee;
import exceptions.NoCommandeEnCoursException;
import util.Util;

/**
 * La classe GestionPizzeria permet de g�rer la pizzeria. Elle retient les pizzas et les clients de celle-ci.
 *
 * @author lecem
 */
public class GestionPizzeria {

    public final PizzaComposee p_4saisons, p_4fromages, p_margarita, p_duchef, p_mariniere;
    /**
     * les clients de la pizzeria
     */
    private List<Client> clients = new ArrayList<Client>();

    /**
     * cr�e les pizzas de la pizzeria.
     */
    public GestionPizzeria() {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(tomate);
        ingredients.add(artichaut);
        ingredients.add(jambon);
        ingredients.add(olives);
        ingredients.add(parmesan);
        ingredients.add(mozza);
        p_4saisons = new PizzaComposee("4 saisons", "4 go�ts qui d�filent selon les saisons", ingredients);
        ingredients = new ArrayList<>();
        ingredients.add(tomate);
        ingredients.add(parmesan);
        ingredients.add(gogonzola);
        ingredients.add(pecorino);
        ingredients.add(mozza);
        p_4fromages = new PizzaComposee("4 fromages", "le m�lange g�n�reux des formages italiens", ingredients);
        ingredients = new ArrayList<>();
        ingredients.add(tomate);
        ingredients.add(mozza);
        p_margarita = new PizzaComposee("margarita", "la simplissit� culinaire", ingredients);
        ingredients = new ArrayList<>();
        ingredients.add(tomate);
        ingredients.add(aubergines);
        ingredients.add(jambon);
        ingredients.add(epinards);
        ingredients.add(mozza);
        ingredients.add(gogonzola);
        p_duchef = new PizzaComposee("du chef", "l'�quilibre des saveurs du chef", ingredients);
        ingredients = new ArrayList<>();
        ingredients.add(tomate);
        ingredients.add(scampis);
        ingredients.add(mozza);
        p_mariniere = new PizzaComposee("marini�re", "les saveurs de l'oc�an", ingredients);


    }


    /**
     * enregistre un nouveau client dans la pizzaeria
     *
     * @param nom       le nom du client
     * @param prenom    le pr�nom du client
     * @param telephone le t�l�phone du client
     * @return le client cr��.
     * @throws IllegalArgumentException Exception lanc�e si l'un des param�tres
     *                                  n'est pas sp�cifi� ou vide.
     */
    public Client enregistrerClient(String nom, String prenom, String telephone) {
        Util.checkString(telephone);
        Util.checkString(nom);
        Util.checkString(prenom);
        Client client = new Client(clients.size() + 1, nom, prenom, telephone);
        clients.add(client);
        return client;
    }

    /**
     * Cr�e une commande
     *
     * @param client le client pour qui la commande est cr��e; ce client appartient
     *               � la liste des clients
     * @return la commande cr��e pour le client sinon null (pas d'exception)
     */
    public Commande creerCommande(Client client) {
        Util.checkObject(client);
        Commande commande = null;
        try {
            commande = new Commande(client);
        } catch (IllegalArgumentException e) {
            return null;
        }
        return commande;
    }

    /**
     * Ajoute � la commande en cours du client la pizza en quantit� indiqu�e
     *
     * @param client   le client qui a une commande en cours � qui on ajoute la
     *                 pizza; ce client appartient � la liste des clients
     * @param pizza    la pizza � rajouter � la commande en cours du client ; la
     *                 pizza appartient � la carte des pizzas
     * @param quantite le nombre de fois qu'on ajouter la pizza � la commande en
     *                 cours du client
     * @throws NoCommandeEnCoursException si le client n'a pas de commande en cours
     * @throws IllegalArgumentException   si la quantit� est n�gative ou nulle
     */
    public void ajouterALaCommande(Client client, Pizza pizza, int quantite) throws NoCommandeEnCoursException {
        Util.checkPositive(quantite);
        Util.checkObject(pizza);
        obtenirCommandeEnCours(client);
        client.getCommandeEnCours().ajouter(pizza, quantite);
    }

    /**
     * Cr�e une pizza composable pour un client � partir des ingr�dients. Ajoute
     * ensuite cette pizza � la commande en cours du client en quantit� pass�e en
     * param�tre.
     *
     * @param client      le client qui a une commande en cours qui cr�e un pizza
     *                    composable ; ce client appartient � la liste des clients
     * @param quantite    le nombre de fois qu'on ajoute la pizza composabe � la
     *                    commande en cours du client
     * @param ingredients les ingr�dients qui composent la pizza composable du
     *                    client ; la liste contient au moins un ingr�dient et tous
     *                    les ingr�dients de la liste sont dans Ingr�dients
     * @throws NoCommandeEnCoursException si le client n'a pas de commande en cours
     * @throws IllegalArgumentException   si la quantit� est n�gative ou nulle
     */
    public void creerPizzaComposable(Client client, int quantite, Ingredient... ingredients)
            throws NoCommandeEnCoursException {
        Util.checkPositive(quantite);
        Util.checkObject(ingredients);
        obtenirCommandeEnCours(client);
        PizzaComposable pizza = new PizzaComposable(client);
        for (Ingredient ingredient : ingredients) {
            pizza.ajouter(ingredient);
        }
        client.getCommandeEnCours().ajouter(pizza, quantite);

    }

    private void obtenirCommandeEnCours(Client client) throws NoCommandeEnCoursException {
        Util.checkObject(client);
        Commande commande = client.getCommandeEnCours();
        if (commande == null)
            throw new NoCommandeEnCoursException("le client n'a pas de commande en cours");
    }

    /**
     * Cr�e une pizza composable pour un client � partir des ingr�dients. Ajoute
     * ensuite cette pizza � la commande en cours du client.
     *
     * @param client      le client qui a une commande en cours qui cr�e un pizza
     *                    composable ; ce client appartient � la liste des clients
     * @param ingredients les ingr�dients qui composent la pizza composable du
     *                    client ; la liste contient au moins un ingr�dient et tous
     *                    les ingr�dients de la liste sont dans Ingr�dients
     * @throws NoCommandeEnCoursException si le client n'a pas de commande en cours
     */
    public void creerPizzaComposable(Client client, Ingredient... ingredients) throws NoCommandeEnCoursException {
        this.creerPizzaComposable(client, 1, ingredients);
    }

    /**
     * Valide la commande en cours du client; la commande devient pass�e et n'est
     * donc plus en cours.
     *
     * @param client le client qui valide sa commande ; ce client appartient � la
     *               liste des clients
     * @throws NoCommandeEnCoursException si le client n'a pas de commande en cours
     */
    public void validerCommande(Client client) throws NoCommandeEnCoursException {
        Util.checkObject(client);
        client.cloturerCommandeEnCours();
    }
}
