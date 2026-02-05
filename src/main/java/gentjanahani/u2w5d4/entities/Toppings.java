package gentjanahani.u2w5d4.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity

@Getter
@Setter
@ToString
@NoArgsConstructor
@DiscriminatorValue("TOPPING")
public class Toppings extends Items{
    @ManyToMany
    private List<Pizza> pizzas=new ArrayList<>();

    public Toppings(String name, int calories, double price) {
        super(name, calories, price);
    }

    public void printInfo(){
        System.out.println(getName() + " - " +
                getCalories() +" kcal - € " +
                getPrice());
    };
}
