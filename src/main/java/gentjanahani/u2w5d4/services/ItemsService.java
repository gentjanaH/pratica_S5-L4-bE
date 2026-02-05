package gentjanahani.u2w5d4.services;


import gentjanahani.u2w5d4.entities.Items;
import gentjanahani.u2w5d4.entities.Toppings;
import gentjanahani.u2w5d4.exceptions.NotFoundException;
import gentjanahani.u2w5d4.repositories.ItemsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ItemsService {

    private final ItemsRepository itemsRepository;

    @Autowired
    public ItemsService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public void saveItems(Items newItems) {

        this.itemsRepository.save(newItems);
        log.info("L'elemento {} è stato salvato correttamente.", newItems.getName());
    }


    public Items findById(long idItems) {
        return itemsRepository.findById(idItems).orElseThrow(() -> new NotFoundException(idItems));
    }

    public void findByIdAndDelete(long idItems) {
        Items itemsFounded = this.findById(idItems);
        itemsRepository.delete(itemsFounded);
        log.info("L'elemento {} è stato eliminato correttamente", itemsFounded.getName());
    }


    public List<Items> filterByNameStartWith(String partialName) {
        return itemsRepository.findByNameStartingWithIgnoreCase(partialName);
    }

    public List<Items> filterByPrice(double price) {
        return itemsRepository.filterByPrice(price);
    }

    public void findAndDeleteByPrice(double price) {
        List<Items> itemsFounded = this.filterByPrice(price);
        itemsFounded.forEach(items -> {
            itemsRepository.delete(items);
            log.info("L'elemento {} è stato eliminato correttamente", items.getName());
        });


    }

    public Toppings findToppingByName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Il nome del topping non può essere vuoto.");
        }
        Toppings topping = itemsRepository.findToppingByName(name);

        if (topping == null) {
            System.out.println("Elemento non trovato");
        }
        return topping;
    }
}
