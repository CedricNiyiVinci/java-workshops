package domaine;

public enum Promo {
    
    PUB("remisePublicitaire"), SOLDE("remiseSolde"), DESTOCKAGE("remiseDestockage");

    private String typePromo;

    //Constructeur:
    private Promo (String typePromo){
        this.typePromo = typePromo;
    }

    public String getTypePromo() {
        return typePromo;
    }

    //Comment ecrire les getters? Sur quel va

}
