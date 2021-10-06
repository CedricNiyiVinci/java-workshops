package domaine;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * La classe PizzaComposable repr�sente la pizza compasable cr�e par un client.
 * Elle connait son client cr�ateur ainsi que sa date de composition.
 *
 * @author lecem
 */
public class PizzaComposable extends Pizza {
    /**
     * le client cr�ateur de la pizza composable
     */
    private Client createur;
    /**
     * la date de la cr�ation de la pizza composable
     */
    private LocalDateTime date;

    /**
     * cr�e une pizza composable pour un client
     *
     * @param client le client qui cr�e la pizza composable
     */
    public PizzaComposable(Client client) {
        super("Pizza composable du client " + client.getNumero(),
                "Pizza de " + client.getNom() + " " + client.getPrenom());
        this.createur = client;
        date = LocalDateTime.now();
    }

    /**
     * le client cr�ateur de la pizza composable
     *
     * @return le client cr�ateur de la pizza composable
     */
    public Client getCreateur() {
        return createur;
    }

    /**
     * la date de cr�ation de la pizza composable
     *
     * @return la date de cr�ation de la pizza composable
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * renvoie la valeur de hashing de l'objet. 2 objets �gaux renvoient la m�me
     * valeur de hashing.
     *
     * @return la valeur de hashing de l'objet
     */

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), date);
    }

    /**
     * Compare l'�galit� de deux pizzas composables. Deux pizzas composables sont
     * �gales si leur titre et leur date de cr�ation sont �gaux.
     *
     * @param obj l'objet qui doit �tre compar� pour �galit�.
     * @return true si les objets sont les m�mes.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PizzaComposable that = (PizzaComposable) o;
        return date.equals(that.date);
    }

}
