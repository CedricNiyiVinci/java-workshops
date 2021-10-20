package domaine;

import exceptions.DateDejaPresenteException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProduitTest {

    private Prix prixAucune;
    private Prix prixPub;
    private Prix prixSolde;
    private Produit echarpe;
    private Produit valise;

    @BeforeEach
    void setUp() throws DateDejaPresenteException {
        this.prixAucune = new Prix();
        this.prixPub = new Prix(Promo.PUB,20);
        this.prixSolde = new Prix(Promo.SOLDE,25);
        this.echarpe = new Produit("Cashmir Echarpe", "Vetement", "Uniqlo");
        this.valise = new Produit("Valise XXL", "Samsonite", "Voyage");
        LocalDate date1 = LocalDate.of(2021,10, 11), date2 = LocalDate.of(2021,10, 14), date3 = LocalDate.of(2021,10, 21);
        this.echarpe.ajouterPrix(date1, prixAucune);
        this.echarpe.ajouterPrix(date2, prixPub);
        this.echarpe.ajouterPrix(date3, prixSolde);

    }

    @Test
    void getMarque() {
    }

    @Test
    void getNom() {
    }

    @Test
    void getRayon() {
    }

    @DisplayName("Test ajouterPrix -> Throws IllegalArgumentExceptions")
    @Test
    void ajouterPrixThrowIllegalArgException(){
        assertThrows(IllegalArgumentException.class,  () ->  valise.ajouterPrix(null,prixPub));
    }

    @DisplayName("Test ajouterPrix -> Throws DateDejaPresenteException")
    @Test
    void ajouterPrixDateDejaPresente(){
        assertThrows(DateDejaPresenteException.class,
                () ->  echarpe.ajouterPrix(LocalDate.of(2021,10, 11),prixPub));
    }

    @Test
    void getPrix() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void testClone() {
    }
}