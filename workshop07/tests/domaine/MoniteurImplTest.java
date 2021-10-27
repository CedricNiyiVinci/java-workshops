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
                // Pas de probleme lors de l'ajout normalment car le stage ajouté
                // précédemment a été ajouté à la semaine 1 donc semaine 8 est libre
                () -> assertTrue(moniteur.ajouterStage(stageValide)),
                () -> assertTrue(moniteur.contientStage(stageValide)
                        && moniteur.nombreDeStages()==2)

        );
    }

    @DisplayName("TestMoniteurTC3")
    @Test
    void TestMoniteurTC3() {
        // Ici on doit ajouter deux stages car on est a l'etat 2 avant le test TC3
        amenerALEtat(2, moniteur);

        assertAll(
                // Pas de probleme lors de l'ajout normalment car les stage ajoutés
                // précédemment ont été ajoutés à aux semaines 1 et 2 donc semaine 8
                // est libre
                () -> assertTrue(moniteur.ajouterStage(stageValide)),
                () -> assertTrue(moniteur.contientStage(stageValide)
                        && moniteur.nombreDeStages()==3)

        );
    }

    @DisplayName("TestMoniteurTC4")
    @Test
    void TestMoniteurTC4() {
        // Ici on doit ajouter trois stages car on est a l'etat 3 avant le test TC4
        amenerALEtat(3, moniteur);

        assertAll(
                // Pas de probleme lors de l'ajout normalment car les stage ajoutés
                // précédemment ont été ajoutés à aux semaines 1, 2 et 3 donc semaine 8
                // est libre
                () -> assertTrue(moniteur.ajouterStage(stageValide)),
                () -> assertTrue(moniteur.contientStage(stageValide)
                        && moniteur.nombreDeStages()==4)

        );
    }

    @DisplayName("TestMoniteurTC5")
    @Test
    void TestMoniteurTC5() {
        // Ici on doit ajouter trois stages et le stage qui va etre suprimer dans
        // le AssertAll car on est a l'etat 4 avant le test TC5
        // TC5 -> Suppresion d'un stage deja present

        amenerALEtat(3, moniteur);
        moniteur.ajouterStage(stageValide);

        assertAll(
                () -> assertTrue(moniteur.supprimerStage(stageValide)),
                // Je verifie que le nombre de stage est bien a 3 et que stageValide
                // n'est plus contenue dans les stages du moniteur
                () -> assertTrue(!moniteur.contientStage(stageValide)
                        && moniteur.nombreDeStages()==3)
        );
    }

    @DisplayName("TestMoniteurTC6")
    @Test
    void TestMoniteurTC6() {
        // Ici on doit ajouter 2 stages et le stage qui va etre suprimer dans
        // le AssertAll car on est a l'etat 3 avant le test TC6
        // TC6 -> Suppresion d'un stage deja present
        amenerALEtat(2, moniteur);
        moniteur.ajouterStage(stageValide);

        assertAll(
                () -> assertTrue(moniteur.supprimerStage(stageValide)),
                // Je verifie que le nombre de stage est bien a 2 et que stageValide
                // n'est plus contenue dans les stages du moniteur
                () -> assertTrue(!moniteur.contientStage(stageValide)
                        && moniteur.nombreDeStages()==2)
        );
    }

    @DisplayName("TestMoniteurTC7")
    @Test
    void TestMoniteurTC7() {
        // Ici on doit ajouter un stage et le stage qui va etre supprimer dans
        // le AssertAll car on est a l'etat 2 avant le test TC7
        // TC7 -> Suppresion d'un stage deja present
        amenerALEtat(1, moniteur);
        moniteur.ajouterStage(stageValide);

        assertAll(
                () -> assertTrue(moniteur.supprimerStage(stageValide)),
                // Je verifie que le nombre de stage est bien a 2 et que stageValide
                // n'est plus contenue dans les stages du moniteur
                () -> assertTrue(!moniteur.contientStage(stageValide)
                        && moniteur.nombreDeStages()==1)
        );
    }

    @DisplayName("TestMoniteurTC8")
    @Test
    void TestMoniteurTC8() {
        // Ici on ne doit pas ajouter pas de stage et seul le stage qui va etre supprimer dans
        // le AssertAll va etre ajouté car on est a l'etat 1 avant le test TC8
        // TC7 -> Suppresion d'un stage deja present
        moniteur.ajouterStage(stageValide);

        assertAll(
                () -> assertTrue(moniteur.supprimerStage(stageValide)),
                // Je verifie que le nombre de stage est bien a 2 et que stageValide
                // n'est plus contenue dans les stages du moniteur
                () -> assertTrue(!moniteur.contientStage(stageValide)
                        && moniteur.nombreDeStages()==0)
        );
    }

    @DisplayName("TestMoniteurTC9")
    @Test
    void TestMoniteurTC9() {
        // Avant le assertAll on va ajouter un stage (et 3 autres),
        // et dans le AssertAll on va tenter de rajouter le meme stage
        // Normalment l'ajout doit echouer
        amenerALEtat(3, moniteur);
        moniteur.ajouterStage(stageValide);

        assertAll(
                () -> assertFalse(moniteur.ajouterStage(stageValide)),
                // Je verifie que le nombre de stage est bien a 4 et que stageValide
                // est contenue dans les stages du moniteur
                () -> assertTrue(moniteur.contientStage(stageValide)
                        && moniteur.nombreDeStages()==4)
        );
    }

    @DisplayName("TestMoniteurTC10")
    @Test
    void TestMoniteurTC10() {
        // Avant le assertAll on va ajouter un stage (et 3 autres),
        // et dans le AssertAll on va tenter de rajouter le meme stage
        // Normalment l'ajout doit echouer
        amenerALEtat(3, moniteur);
        moniteur.ajouterStage(stageValide);
        Stage stageValideMemeSemaine = new StageStub(8,sportCompetant, null);

        assertAll(
                () -> assertFalse(moniteur.ajouterStage(stageValideMemeSemaine)),
                // Je verifie que le nombre de stage est bien a 4 et que stageValide
                // est contenue dans les stages du moniteur
                () -> assertTrue(moniteur.contientStage(stageValide)
                        && moniteur.nombreDeStages()==4)
        );
    }

    @DisplayName("TestMoniteurTC11")
    @Test
    void TestMoniteurTC11() {
        // Avant le assertAll on va ajouter 4 stages ,
        // et dans le AssertAll on va tenter de supprimer stageValide qui n'est pas present dans les stages du moniteur
        // Normalment la suppresion doit echouer
        amenerALEtat(4, moniteur);


        assertAll(
                () -> assertFalse(moniteur.supprimerStage(stageValide)),
                // Je verifie que le nombre de stage est bien a 4
                () -> assertEquals(4, moniteur.nombreDeStages())
        );
    }

    @DisplayName("TestMoniteurTC12")
    @Test
    void TestMoniteurTC12() {
        // Avant le assertAll on va ajouter 4 stages ,
        amenerALEtat(4, moniteur);
        Moniteur moniteurTest = new MoniteurImpl("Vincent");
        Stage stageTest = new StageStub(5,sportCompetant,moniteurTest);

        assertAll(
                () -> assertFalse(moniteur.ajouterStage(stageTest)),
                // Je verifie que le nombre de stage est bien a 4 (n'a pas changer)
                () -> assertEquals(4, moniteur.nombreDeStages())
        );
    }

    @DisplayName("TestMoniteurTC13")
    @Test
    void TestMoniteurTC13() {
        // Avant le assertAll on va ajouter 4 stages ,
        amenerALEtat(4, moniteur);
        Stage stageTest = new StageStub(5,sportCompetant,moniteur);

        assertAll(
                () -> assertTrue(moniteur.ajouterStage(stageTest)),
                // Je verifie que le nombre de stage est bien a 4 (n'a pas changer)
                () -> assertTrue(moniteur.contientStage(stageTest)
                        && moniteur.nombreDeStages()==5)
        );
    }

    @DisplayName("TestMoniteurTC14")
    @Test
    void TestMoniteurTC14() {
        Sport sportIncompetant = new SportStub(false);
        Stage stageTest = new StageStub(1,sportIncompetant,null);

        assertAll(
                () -> assertFalse(moniteur.ajouterStage(stageTest)),
                // Je verifie que le nombre de stage est bien a 4 (n'a pas changer)
                () -> assertEquals(0, moniteur.nombreDeStages())
        );
    }

}