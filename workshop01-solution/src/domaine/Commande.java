package domaine;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

import util.Util;

/**
 * La classe Commande repr�sente la commande. Elle connait son num�ro, son
 * client, sa date ainsi que toutes les pizzas command�es (avec leur quantit�).
 *
 * @author lecem
 */
public class Commande implements Iterable<LigneCommande> {
    /**
     * le nombre de commandes cr��es.
     */
    private static int numero = 1;
    /**
     * le num�ro de la commande
     */
    private int num;
    /**
     * le client qui passe la commande
     */
    private Client client;
    /**
     * les pizzas command�es avec leur quantit� sous forme de collection de LigneCommande
     */
    private ArrayList<LigneCommande> lignesCommandes = new ArrayList<>();
    /**
     * la date de la commande
     */
    private LocalDateTime date;

    /**
     * Cr�e une commande. La commande poss�dera un num�ro auto-incr�ment� dans la
     * classe et sa date de cr�ation est mise � jour.
     *
     * @param client Le client qui passe la commande � cr�er
     * @throws IllegalArgumentException Exception lanc�e si le client a d�j� une
     *                                  commande en cours ou s'il est null
     */
    public Commande(Client client) {
        Util.checkObject(client);
        this.client = client;
        date = LocalDateTime.now();
        if (!client.ajouterCommandeEnCours(this))
            throw new IllegalArgumentException("Le client a d�j� une commande en cours");
        this.num = numero++;
    }

    /**
     * ajouter � la commande une quantit� d'une pizza. Si la pizza se trouve d�j�
     * dans la commande, il faut modifier la quantit� command�e en ajoutant la
     * quantit� � celle d�j� command�e. Si cette pizza n'a pas encore �t� command�e,
     * il faut l'ajouter � la commande.
     *
     * @param pizza    pizza � ajouter dans la commande
     * @param quantite quantit� de pizza � ajouter dans la commande
     * @return true si la pizza a bien �t� ajout� dans la commande avec la quantit�
     * souhait�e
     * @throws IllegalArgumentException Exception lanc�e si la pizza est null ou
     *                                  si la quantit� n'est pas positive
     */
    public boolean ajouter(Pizza pizza, int quantite) {
        Util.checkPositive(quantite);
        Util.checkObject(pizza);
        LigneCommande ligne = null;
        for (LigneCommande ligneCommande : lignesCommandes) {
            if (ligneCommande.getPizza().equals(pizza)) {
                ligne = ligneCommande;
                break;
            }
        }
        if (ligne != null) {
            lignesCommandes.remove(ligne);
            lignesCommandes.add(new LigneCommande(ligne.getQuantite() + quantite, pizza));
        } else
            lignesCommandes.add(new LigneCommande(quantite, pizza));
        return true;

    }

    /**
     * retire de la commande une quantité d'une pizza. Si la pizza se trouve bien
     * dans la commande, il faut :
     * - modifier la quantité commandée s'il reste au moins une pizza après avoir retiré la quantité demandée
     * - supprimer la ligne de commande sil ne reste plus de pizza après avoir retiré la quantité commandée
     *
     * @param pizza    pizza à retirer de la commande
     * @param quantite quantité de pizza à retirer de la commande
     * @return true si la pizza a bien été retirée de la commande même si la quantité souhaitée est supérieure
     * false si aucune pizza n'a pu être retirée
     * @throws IllegalArgumentException Exception lancée si la pizza est null ou
     *                                  si la quantité n'est pas positive
     */
    public boolean retirer(Pizza pizza, int quantite) {
        Util.checkPositive(quantite);
        Util.checkObject(pizza);
        LigneCommande ligne = null;
        for (LigneCommande ligneCommande : lignesCommandes) {
            if (ligneCommande.getPizza().equals(pizza)) {
                ligne = ligneCommande;
                break;
            }
        }
        if (ligne != null) {
            if (quantite >= ligne.getQuantite())
                lignesCommandes.remove(ligne);
            else
                ligne.setQuantite(ligne.getQuantite() - quantite);
            //lignesCommandes.add(new LigneCommande(ligne.getQuantite() + quantite, pizza));
            return true;
        } else
            return false;


    }

    /**
     * renvoie la valeur de hashing de l'objet. 2 objets �gaux renvoient la m�me
     * valeur de hashing.
     *
     * @return la valeur de hashing de l'objet
     */
    @Override
    public int hashCode() {
        return Objects.hash(num);
    }

    /**
     * compare l'�galit� de deux commandes. Deux commandes sont �gales si elles ont
     * le m�me num�ro.
     *
     * @param obj l'objet qui doit �tre compar� pour �galit�.
     * @return true si les objets sont les m�mes (m�me num�ro).
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commande that = (Commande) o;
        return num == that.num;
    }


    /**
     * renvoie le num�ro de la commande
     *
     * @return le num�ro de la commande
     */
    public int getNum() {
        return num;
    }

    /**
     * renvoie le client de la commande
     *
     * @return le client de la commande
     */
    public Client getClient() {
        return client;
    }

    /**
     * renvoie la date de la commande
     *
     * @return la date de la commande
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * convertit la commande sous forme de String : <br>Commande <em> en cours (ou
     * pas)</em> [num�ro=<em> son num�ro</em>, client=<em> son client</em> , date=
     * <em> sa date</em>]
     *
     * @return repr�sentation textuelle du client
     */
    @Override
    public String toString() {
        String encours = "";
        if (client.getCommandeEnCours() == this)
            encours = "en cours ";
        return "Commande " + encours + " [num�ro=" + num + ", client=" + client + ", date=" + date + "]";
    }

    /**
     * calcule le prix total de la commande sur base des quantit�s command�es de
     * chaque pizza.
     *
     * @return le prix de la commande
     */
    public double calculerMontantTotal() {
        double total = 0;
        for (LigneCommande ligneCommande : lignesCommandes) {
            total += ligneCommande.calculerPrixTotal();
        }
        return total;

    }

    /**
     * convertit la commande sous forme de String d�taill� : <br>D�tails de la commande
     * <em> son num�ro</em> (total <em> son prix total</em> �)\n <br>
     * Ensuite chaque ligne de commande est ajout�e avec un \n
     *
     * @return le d�tail de la commande
     */
    public String detailler() {
        String detail = "D�tails de la commande " + num + " (total :" + calculerMontantTotal() + " �)\n";
        for (LigneCommande ligneCommande : lignesCommandes) {
            detail += ligneCommande + "\n";
        }
        return detail;
    }

    /**
     * @return l'iterator des pizzas command�es pass�es (LignesCommandes)
     */
    @Override
    public Iterator<LigneCommande> iterator() {
        return lignesCommandes.iterator();
    }

}
