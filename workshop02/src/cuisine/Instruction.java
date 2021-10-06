package cuisine;

import java.time.Duration;

public class Instruction {

    private String description;
    private Duration dureeEnMinutes;

    public Instruction(String description, int dureeEnMinutes) {
        this.description = description;
        this.dureeEnMinutes = Duration.ofMinutes(dureeEnMinutes);
    }

    public String getDescription() {
        return description;
    }

    public Duration getDureeEnMinutes() {
        return dureeEnMinutes;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDureeEnMinutes(Duration dureeEnMinutes) {
        this.dureeEnMinutes = dureeEnMinutes;
    }

    public String toString(){
        long nbHeures = dureeEnMinutes.toHours();
        long nbrMinutes = dureeEnMinutes.toMinutes() % 60;
        String aRenvoyer =  "(" + String.format("%02:%20d", nbHeures,nbrMinutes) + ")" + description;
        return aRenvoyer;
    }
}
