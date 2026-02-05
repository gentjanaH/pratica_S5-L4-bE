package gentjanahani.u2w5d4.runners;

import gentjanahani.u2w5d4.entities.Items;
import gentjanahani.u2w5d4.entities.Pizza;
import gentjanahani.u2w5d4.entities.Toppings;
import gentjanahani.u2w5d4.repositories.ItemsRepository;
import gentjanahani.u2w5d4.services.ItemsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Slf4j
public class Runner implements CommandLineRunner {

private final ItemsRepository itemsRepository;

	@Autowired
	public Runner(ItemsRepository itemsRepository) {
		this.itemsRepository = itemsRepository;
	}

//private final ItemsService itemsService;
//
//
//public Runner(ItemsService itemsService){
//    this.itemsService=itemsService;
//}


    @Override
    public void run(String... args) throws Exception {
        ArrayList<Toppings> toppings = new ArrayList<>();
        Pizza pizzaMargherita=new Pizza("Margherita", toppings, 1104, 4.99 );

        itemsRepository.save(pizzaMargherita);

    }
}
