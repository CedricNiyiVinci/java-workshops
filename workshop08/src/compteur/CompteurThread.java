package compteur;

public class CompteurThread extends Thread {

    private final String nom;
    private final int max;

    //Cette variable de classe permet de retenir quel CompteurThread
    //a fini de compter le premier.
    private static CompteurThread gagnant;

    public CompteurThread(String nom, int max) {
        this.nom = nom;
        this.max = max;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public void run() {

        //TODO: 1. Compter jusqu'à max en attendant 10 ms entre chaque incrémentation
        //         A chaque incrémentation, afficher le nom du compteur et son compte actuel.
        int compteur = 0;
        while (compteur < max) {

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            compteur++;
            System.out.println(this.nom + " : compteur -> " + compteur);
        }
        //      2. Quand le compte est terminé, afficher que le compteur a finit de compter.
        //         Si le gagnant actuel est null, attendre 10 ms et mettre le gagnant à this,
        //         puis afficher que ce thread est le gagnant.
        synchronized (CompteurThread.class) { // Il faut bloquer toute modification sur la class, si je le fais seulement sur
                                              // l'objet gagnant j'aurais des soucis vu qu'il est null avant de rentrer dans le bloc if ci dessous
            if (gagnant == null) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                gagnant = this;
                System.out.printf("Le compteur de " + getGagnant().nom + " est à " + compteur + "\n" + getGagnant().nom + " a gagné!");
            }
        }

    }

    public static CompteurThread getGagnant() {
        return gagnant;
    }
}
