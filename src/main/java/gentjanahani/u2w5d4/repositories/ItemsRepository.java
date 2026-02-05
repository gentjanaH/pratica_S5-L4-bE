package gentjanahani.u2w5d4.repositories;

import gentjanahani.u2w5d4.entities.Items;
import gentjanahani.u2w5d4.entities.Toppings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Long> {

    List<Items> findByNameStartingWithIgnoreCase(String partialName);


    @Query("SELECT t FROM Items t WHERE TYPE(t) = Toppings AND LOWER(t.name) = LOWER(:name)")
    Toppings findToppingByName(String name);

    @Query("SELECT i FROM Items i WHERE i.price <= :price")
    List<Items> filterByPrice(double price);


}
