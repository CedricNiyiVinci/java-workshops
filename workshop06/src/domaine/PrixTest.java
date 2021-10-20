package domaine;

import exceptions.QuantiteNonAutoriseeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

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

    @DisplayName("Tests du getter typeDePromo")
    @Test
    void getTypePromoValeurPromo() {
        assertAll(
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
        assertAll(
                // Verification valeurPromo=0, lors de l'initialisation sd'un prix a l'aide d'un constructeur
                // sans parametre (Cas de notre attribut prixAucune)
                () -> assertEquals(0,prixAucune.getValeurPromo()),
                // Vérifier que la valeur de la promo correspond bien à celle passée en paramètre du constructeur.
                //cas Prix Pub
                () -> assertEquals(20, prixPub.getValeurPromo()),
                //cas Solde
                () -> assertEquals(25, prixSolde.getValeurPromo())
        );

    }

    @DisplayName("Test qui permet de verifier si la methode renvoie une exception")
    @Test
    void definirPrixParamZeroOrNull() {
        //Double ancienPrix = prixAucune.getPrix(10);
        assertAll(
            //Cas ou le parametre quantite est negatif ou ==0
            () -> assertThrows(IllegalArgumentException.class,
                    () -> prixPub.definirPrix(0,20)),
            //Cas ou le parametre valeur est negatif ou ==0
            () -> assertThrows(IllegalArgumentException.class,
                    () -> prixPub.definirPrix(20,-20))
        );
    }
    @DisplayName("Test qui permet de verifier si la methode renvoie une exception")
    @Test
    void definirPrixRemplacement() throws QuantiteNonAutoriseeException{
        Double ancienPrix = prixAucune.getPrix(10);
        prixAucune.definirPrix(10,6);
        assertNotEquals(ancienPrix, prixAucune.getPrix(10) );
    }

    @DisplayName("Test du getter qui renvoie le prix unitaire pour une quantité donnée")
    @Test
    void getPrix() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class,
                        () -> prixPub.getPrix(0)),
                () -> assertEquals(20, prixAucune.getPrix(1)),
                () -> assertEquals(20, prixAucune.getPrix(5)),
                () -> assertEquals(20, prixAucune.getPrix(9)),
                () -> assertEquals(10, prixAucune.getPrix(10)),
                () -> assertEquals(10, prixAucune.getPrix(15)),
                () -> assertEquals(10, prixAucune.getPrix(20)),
                () -> assertEquals(10, prixAucune.getPrix(25)),
                () -> assertThrows(QuantiteNonAutoriseeException.class,
                        () -> prixPub.getPrix(2)),
                () -> assertThrows(QuantiteNonAutoriseeException.class,
                        () -> prixSolde.getPrix(1))
        );
    }

    @DisplayName("Test de clonage : Cas difference entre un objet et son clone")
    @Test
    void testCloneDifferent() {
        Prix prixPubClone = prixPub.clone();
        assertNotSame(prixPub, prixPubClone);

    }


    @DisplayName("Test de clonage : Egalité des propriétés entre une objet et son clonz")
    @Test
    void testCloneProprieteEgale() {
        Prix prixPubClone = prixPub.clone();
        assertAll(
                () -> assertEquals(prixPub.getValeurPromo(), prixPubClone.getValeurPromo()),
                () -> assertSame(prixPub.getTypePromo(), prixPubClone.getTypePromo())
        );
    }

    @DisplayName("Test de clonage : ")
    @Test
    void testCloneValeurQuantite() throws QuantiteNonAutoriseeException{
        Prix prixPubClone = prixPub.clone();
        assertEquals(15, prixPubClone.getPrix(3));
    }

    @DisplayName("Test de clonage : ")
    @Test
    void testCloneValeurQuantiteRemplacement() {
        Prix prixAucuneClone = prixAucune.clone();
        prixAucuneClone.definirPrix(15,6);
        assertAll(
                () -> assertEquals(20, prixAucuneClone.getPrix(1)),
                () -> assertNotEquals(10, prixAucuneClone.getPrix(15))
        );
    }


}