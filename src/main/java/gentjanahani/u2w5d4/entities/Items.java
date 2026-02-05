package gentjanahani.u2w5d4.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="elementi_menu")
@Getter
@Setter
@ToString
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type")
public abstract class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private  long idItemsMenu;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int calories;
    @Column(nullable = false)
    private double price;

    public Items(String name, int calories, double price){
        this.name=name;
        this.calories=calories;
        this.price=price;
    }

    public abstract void printInfo();
}
