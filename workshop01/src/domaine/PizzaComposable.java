package domaine;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class PizzaComposable extends Pizza{

    private LocalDate date;
    private Client createur;

    public PizzaComposable(Client createur) {
        super("Pizza composable du client " + createur.getNumero(), "Pizza de " + createur.getNom() + " " + createur.getPrenom());
        this.date = LocalDate.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PizzaComposable that = (PizzaComposable) o;
        return Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), date);
    }
}
