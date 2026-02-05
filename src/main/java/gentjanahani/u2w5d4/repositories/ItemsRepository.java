package gentjanahani.u2w5d4.repositories;

import gentjanahani.u2w5d4.entities.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Long> {

}
