package abonnements;

public class Abonnement extends Thread {

    private final String nom;
    private final double prixMensuel;
    private final Compte compte;

    public Abonnement(String nom, double prixMensuel, Compte compte) {
        this.nom = nom;
        this.prixMensuel = prixMensuel;
        this.compte = compte;
    }

    @Override
    public void run() {
        boolean retraitPossible=true;


        while(retraitPossible) {
            synchronized (compte) {
                if (!(compte.getSolde() >= prixMensuel))
                    retraitPossible = false;
                if (retraitPossible)
                    compte.depenser(new Depense(prixMensuel, "domiciliation pour " + nom));
            }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

    }
}
