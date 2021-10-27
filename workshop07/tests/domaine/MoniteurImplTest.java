package domaine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoniteurImplTest {

    // On va déclarer 3 objets : 1 moniteur / 1 sport / 1 stage
    private Moniteur moniteur;
    private Sport sportCompetant;
    private  Stage stageValide;


    @BeforeEach
    void setUp() {
        moniteur = new MoniteurImpl("Niyikiza");
        sportCompetant = new SportStub(true);
        stageValide = new StageStub(8, sportCompetant, null);
        // pq NULL

    }

    private void amenerALEtat(int etat, Moniteur moniteur){
        for (int i = 1; i <= etat; i++) {
            moniteur.ajouterStage(new StageStub(i, sportCompetant, null));
        }
    }

    @Test
    void getNom() {
    }

    @Test
    void estLibre() {
    }

    @DisplayName("TestMoniteurTC1")
    @Test
    void TestMoniteurTC1() {
        // Ici il ne faut pas ajouter de projet car on est dans le cas ou il n'y a aucun stage au debut
        assertAll(
                () -> assertTrue(moniteur.ajouterStage(stageValide)),
                () -> assertTrue(moniteur.contientStage(stageValide)),
                // Je verifie aussi si le nombre de stage est bien à 1, apres ajout
                () -> assertEquals(1, moniteur.nombreDeStages())
        );
    }

    @DisplayName("TestMoniteurTC2")
    @Test
    void TestMoniteurTC2() {
        // Ici on doit ajouter un un stage car on est a l'etat 1 avant le test TC2
        amenerALEtat(1, moniteur);

        assertAll(

        );
    }

    @DisplayName("TestMoniteurTC3")
    @Test
    void TestMoniteurTC3() {
        // Ici on doit ajouter un un stage car on est a l'etat 1 avant le test TC3
        amenerALEtat(2, moniteur);

        assertAll(

        );
    }

    @DisplayName("TestMoniteurTC4")
    @Test
    void TestMoniteurTC4() {
        // Ici on doit ajouter un un stage car on est a l'etat 1 avant le test TC2
        amenerALEtat(3, moniteur);

        assertAll(

        );
    }

    @DisplayName("TestMoniteurTC5")
    @Test
    void TestMoniteurTC5() {
        // Ici on doit ajouter un un stage car on est a l'etat 1 avant le test TC2
        amenerALEtat(4, moniteur);

        assertAll(

        );
    }

    @DisplayName("TestMoniteurTC6")
    @Test
    void TestMoniteurTC6() {
        // Ici on doit ajouter un un stage car on est a l'etat 1 avant le test TC2
        amenerALEtat(3, moniteur);

        assertAll(

        );
    }

    @Test
    void supprimerStage() {
    }

    @Test
    void contientStage() {
    }

    @Test
    void nombreDeStages() {
    }

    @Test
    void stages() {
    }
}