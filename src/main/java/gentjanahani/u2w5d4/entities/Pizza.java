package gentjanahani.u2w5d4.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity

@Getter
@Setter

@NoArgsConstructor
@DiscriminatorValue("PIZZA")
public class Pizza extends Items {

    @ManyToMany(mappedBy = "pizzas")
    private List<Toppings> toppings = new ArrayList<>();

    private static final int baseCalorie = 1104;
    private static final double basePrezzo = 4.99;

    public Pizza(String name, List<Toppings> toppings) {

        super(name, 0, 0);
        Toppings tomato = new Toppings("Tomato", 50, 0.00);
        Toppings cheese = new Toppings("Cheese", 92, 0.69);
        this.toppings = new ArrayList<>();
        this.toppings.add(tomato);
        this.toppings.add(cheese);
        this.toppings.addAll(toppings);
        this.setCalories(calcolaCalorie());
        this.setPrice(calcolaPrezzoPizza());
    }

    public int calcolaCalorie() {
        int totaleCalorie = baseCalorie;
        for (Toppings t : this.toppings) {
            totaleCalorie += t.getCalories();
        }
        return totaleCalorie;
    }

    public double calcolaPrezzoPizza() {
        double totalePrezzo = basePrezzo;
        for (Toppings t : this.toppings) {
            totalePrezzo += t.getPrice();
        }
        return totalePrezzo;
    }

    public void addToppings(Toppings topping) {
        this.toppings.add(topping);

        this.setCalories(calcolaCalorie());
        this.setPrice(calcolaPrezzoPizza());
    }

    public String getToppingsList() {
        List<String> ingredienti = new ArrayList<>();
        toppings.forEach(t -> ingredienti.add(t.getName()));
        return String.join(", ", ingredienti);
    }

    @Override
    public void printInfo() {
        System.out.println(getName() + " - " +
                " (" + getToppingsList() + ")  " +
                " - " + calcolaCalorie() + " kcal - € " +
                calcolaPrezzoPizza());


    }

    @Override
    public String toString() {
        return "Pizza{" +
                "nome: " + getName() +
                " prezzo: " + getPrice() +

//                "toppings=" + toppings +
                '}';
    }
}
