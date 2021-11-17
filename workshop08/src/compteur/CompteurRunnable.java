package compteur;

import java.util.concurrent.atomic.AtomicInteger;

public class CompteurRunnable implements Runnable {

    private String nom;
    private int max;
    //ajouter un attribut de classe qui retient l'ordre d'arrivée.
    public static AtomicInteger position;

    @Override
    public void run() {
        position = new AtomicInteger(0);
        //TODO: 1. Compter jusqu'à max en attendant 10 ms entre chaque incrémentation
        //         A chaque incrémentation, afficher le nom du compteur et son compte actuel.
        int compteur = 0 ;
        while (compteur < max) {

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            compteur++;
            System.out.println(this.nom + " : compteur -> " + compteur);
        }
        //      2. Quand le compte est terminé, afficher que le compteur a finit de compter
        //         et indiquer son ordre d'arrivée.

        System.out.println(this.nom + " a fini de compter en position " + position.incrementAndGet());
        // Il ne faut pas faire l'incrementation de position hors du print; mais dans le print
        // AtomicInteger est un type qui s'occupe de la synchronisation
    }

    public CompteurRunnable(String nom, int max) {
        this.nom = nom;
        this.max = max;
    }

    public String getNom() {
        return nom;
    }

}