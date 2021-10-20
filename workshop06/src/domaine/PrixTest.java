package domaine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrixTest {

    private Prix prixAucune;
    private Prix prixPub;
    private Prix prixSolde;

    @BeforeEach
    void setUp() {
        this.prixAucune = new Prix();
        this.prixPub = new Prix(Promo.PUB,20);
        this.prixSolde = new Prix(Promo.SOLDE,25);

        this.prixAucune.definirPrix(1, 20);
        this.prixAucune.definirPrix(10, 10);
        this.prixPub.definirPrix(3,15);
    }

    @DisplayName("Test du Constructeur")
    @Test
    void testConstructeur() {
        assertAll(
                // Vérifier que le constructeur lance une IllegalArgumentException si la promo passée en
                // paramètre est null.
                () -> assertThrows(IllegalArgumentException.class,
                        () -> new Prix(null, 10)),
                //  Vérifier que le constructeur lance une IllegalArgumentException si la valeur passée en
                //  paramètre est < 0.
                () -> assertThrows(IllegalArgumentException.class,
                    () -> new Prix(Promo.PUB, -25))
        );
    }

    @DisplayName("Test du getter typeDePromo")
    @Test
    void getTypePromo() {
        assertAll(
                // Verification valeurPromo=0, lors de l'initialisation sd'un prix a l'aide d'un constructeur
                // sans parametre (Cas de notre attribut prixAucune)
                () -> assertEquals(0,prixAucune.getValeurPromo()),
                // Vérifier que la valeur de la promo correspond bien à celle passée en paramètre du constructeur.
                    //cas Prix Pub
                () -> assertEquals(20, prixPub.getValeurPromo()),
                    //cas Solde
                () -> assertEquals(25, prixSolde.getValeurPromo()),
                // Vérifier que le type de la promo est null lors de l’instanciation d’un prix au moyen du
                //constructeur sans paramètre
                () -> assertNull(prixAucune.getTypePromo()),
                // Vérifier que le type de la promo correspond bien à celle passée en paramètre du constructeu
                    //cas prixPub
                () -> assertSame(Promo.PUB, prixPub.getTypePromo()),
                    //cas prixSolde
                () -> assertSame(Promo.SOLDE, prixSolde.getTypePromo())
        );
    }

    @DisplayName("Test du getter qui renvoie la valeur de la promo")
    @Test
    void getValeurPromo() {
    }

    @DisplayName("Test qui permet de definir le prix unitaire pour une quantité donnée")
    @Test
    void definirPrix() {
    }

    @DisplayName("Test du getter qui renvoie le prix unitaire pour une quantité donnée")
    @Test
    void getPrix() {
    }

    @DisplayName("Test de clonage")
    @Test
    void testClone() {
    }
}