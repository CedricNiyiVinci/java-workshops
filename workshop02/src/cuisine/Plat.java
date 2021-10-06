package cuisine;

import util.Util;

import java.time.Duration;
import java.util.*;

public class Plat {

    // nom (String), nbPersonnes (int), niveauDeDifficulte (Difficulte),
    //cout (Cout) et dureeEnMinutes (Duration).

    private String nom;
    private int nbrPersonnes;
    private Difficulte niveauDeDifficulte;
    private Cout cout;
    private Duration dureeEnMinutes;
    private List<Instruction> instructions;
    private Set<IngredientQuantifie> ingredients;

    public Plat(String nom, int nbrPersonnes, Difficulte niveauDeDifficulte, Cout cout) {
        this.nom = nom;
        this.nbrPersonnes = nbrPersonnes;
        this.niveauDeDifficulte = niveauDeDifficulte;
        this.cout = cout;
        this.dureeEnMinutes = Duration.ofMinutes(0);
        this.instructions = new ArrayList<Instruction>();
        this.ingredients = new HashSet<IngredientQuantifie>();
    }

    public String getNom() {
        return nom;
    }

    public int getNbrPersonnes() {
        return nbrPersonnes;
    }

    public Difficulte getNiveauDeDifficulte() {
        return niveauDeDifficulte;
    }

    public Cout getCout() {
        return cout;
    }

    public Duration getDureeEnMinutes() {
        return dureeEnMinutes;
    }

    /**
     * insère l’instruction à la position précisée, position commençant à 1.
     * @param position
     * @param instruction
     */
    void insererInstruction(int position, Instruction instruction){
        Util.checkPositive(position);
        Util.checkObject(instruction);
        if(position>instructions.size()) throw new IllegalArgumentException();
        instructions.add(position-1,instruction);
    }

    /**
     * ajoute l’instruction en dernier.
     * @param instruction
     */
    void ajouterInstruction (Instruction instruction){
        Util.checkObject(instruction);
        instructions.add(instruction);
    }

    /**
     * remplace l’instruction à la position précisée par celle en paramètre.
     * renvoie l’instruction qui a été remplacée
     * @param position
     * @param instruction
     * @return
     */
    Instruction remplacerInstruction (int position, Instruction instruction){
        Util.checkPositive(position);
        Util.checkObject(instruction);
        if(position>instructions.size()) throw new IllegalArgumentException();
        Instruction ancienneInstruction = instructions.get(position-1);
        instructions.set(position-1, instruction);
            return ancienneInstruction;
    }

    /**
     * supprimer l’instruction à la position précisée
     * renvoie l’instruction qui a été supprimée
     * @param position
     * @return
     */
    Instruction supprimerInstruction (int position){
        Util.checkPositive(position);
        if(position>instructions.size()) throw new IllegalArgumentException();
        Instruction ancienneInstruction = instructions.get(position-1);
        instructions.remove(position-1);
            return ancienneInstruction;
    }

    /**
     * crée un IngrédientQuantifie et l’ajoute si l’ingrédient n’est pas encore
     * présent. Cela renvoie false si l’ingrédient est déjà présent.
     * @param ingredient
     * @param quantite
     * @param unite
     * @return
     */
    public boolean ajouterIngredient(Ingredient ingredient, int quantite, Unite unite){
        IngredientQuantifie ingredientQuantifieAAjoute = new IngredientQuantifie(ingredient,quantite,unite);
        if(this.ingredients.contains(ingredientQuantifieAAjoute)) return false;
        ingredients.add(ingredientQuantifieAAjoute);
            return true;
    }


    /**
     * crée un IngrédientQuantifie et l’ajoute si l’ingrédient n’est pas encore
     * présent. Cela renvoie false si l’ingrédient est déjà présent.
     * unité mise par défaut est NEANT
     * @param ingredient
     * @param quantite
     * @return
     */
    public boolean ajouterIngredient(Ingredient ingredient, int quantite){
        IngredientQuantifie ingredientQuantifieAAjoute = new IngredientQuantifie(ingredient,quantite,Unite.NEANT);
        if(this.ingredients.contains(ingredientQuantifieAAjoute)) return false;
        ingredients.add(ingredientQuantifieAAjoute);
        return true;
    }

    /**
     * modifie l’unité et la quantité de l’ingrédient quantifié correpondant à
     * l’ingrédient passé en paramètre.
     * renvoie false si l’ingredient n’est pas présent.
     * @param ingredient
     * @param quantite
     * @param unite
     * @return
     */
    public boolean modifierIngredient(Ingredient ingredient, int quantite, Unite unite){
        IngredientQuantifie ingredientQuantifieAModifier = new IngredientQuantifie(ingredient, 0,Unite.NEANT);
        if (!ingredients.contains(ingredient)) return false;

    }


    public Iterator<Instruction> instructions(){
        return instructions.iterator();
    }

    public enum Difficulte{
        X, XX, XXX, XXXX;

        @Override
        public String toString() {
            return super.toString().replace("X", "*");
        }
    }

    public enum Cout{
        $, $$, $$$, $$$$ ,$$$$$;

        @Override
        public String toString() {
            return super.toString().replace("$", "€");
        }
    }


}
