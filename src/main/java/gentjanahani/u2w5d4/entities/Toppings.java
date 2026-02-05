package gentjanahani.u2w5d4.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity

@Getter
@Setter
@ToString
public class Toppings extends Items{

    public Toppings(String name, int calories, double price) {
        super(name, calories, price);
    }

    public void printInfo(){
        System.out.println(getName() + " - " +
                getCalories() +" kcal - € " +
                getPrice());
    };
}
