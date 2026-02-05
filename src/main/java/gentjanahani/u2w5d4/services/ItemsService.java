package gentjanahani.u2w5d4.services;


import gentjanahani.u2w5d4.entities.Items;
import gentjanahani.u2w5d4.repositories.ItemsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ItemsService {

    private final ItemsRepository itemsRepository;

    @Autowired
    public ItemsService(ItemsRepository itemsRepository){
        this.itemsRepository=itemsRepository;
    }

    public void saveItems(Items newItems){

      this.itemsRepository.save(newItems);
        log.info("L'elemento {} è stato salvato correttamente.", newItems.getName());
    }

}
