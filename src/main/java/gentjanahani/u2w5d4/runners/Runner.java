package gentjanahani.u2w5d4.runners;

import gentjanahani.u2w5d4.entities.Drinks;
import gentjanahani.u2w5d4.entities.Items;
import gentjanahani.u2w5d4.entities.Pizza;
import gentjanahani.u2w5d4.entities.Toppings;
import gentjanahani.u2w5d4.exceptions.NotFoundException;
import gentjanahani.u2w5d4.repositories.ItemsRepository;
import gentjanahani.u2w5d4.services.ItemsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class Runner implements CommandLineRunner {

//private final ItemsRepository itemsRepository;

    //	@Autowired
//	public Runner(ItemsRepository itemsRepository) {
//		this.itemsRepository = itemsRepository;
//	}
//
    private final ItemsService itemsService;


    public Runner(ItemsService itemsService) {
        this.itemsService = itemsService;
    }


    @Override
    public void run(String... args) throws Exception {
        List<Toppings> toppings = new ArrayList<>();
        Pizza pizzaMargherita = new Pizza("Margherita", toppings);

        //creo nuovi toppings
        Toppings prosciutto = new Toppings("Prosciutto cotto", 150, 1.50);
        Toppings prosciuttoCrudo = new Toppings("Prosciutto crudo", 120, 2.50);
        Toppings funghi = new Toppings("Funghi champignon", 35, 0.80);
        Toppings carciofi = new Toppings("Carciofi", 40, 0.90);
        Toppings oliveNere = new Toppings("Olive nere", 25, 0.50);
        Toppings cipolla = new Toppings("Cipolla", 20, 0.40);
        Toppings tonno = new Toppings("Tonno", 100, 1.40);
        Toppings wurstel = new Toppings("Wurstel", 180, 1.20);
        Toppings patatineFritte = new Toppings("Patatine fritte", 280, 1.50);
        Toppings salamePiccante = new Toppings("Salame piccante", 160, 1.50);
        Toppings uovoSodo = new Toppings("Uovo sodo", 260, 1.50);
        Toppings mozzarella = new Toppings("Mozzarella", 260, 1.00);

        //creo nuovi drink
        Drinks acqua = new Drinks("acqua naturale", 0, 1.50);
        Drinks acquaFrizzante = new Drinks("Acqua frizzante", 0, 1.50);
        Drinks cocaCola = new Drinks("Coca Cola", 140, 2.50);
        Drinks limonata = new Drinks("Limonata", 90, 2.00);
        Drinks birraMedia = new Drinks("Birra media", 180, 4.50);
        Drinks vinoRosso = new Drinks("Vino rosso (calice)", 125, 3.00);
        Drinks vinoBianco = new Drinks("Vino bianco (calice)", 110, 3.00);

        //creo nuove pizze
        Pizza americana = new Pizza("Americana", List.of(wurstel, patatineFritte));
        Pizza capricciosa = new Pizza("Capricciosa", List.of(prosciuttoCrudo, oliveNere, funghi, uovoSodo, carciofi));
        Pizza diavola = new Pizza("Diavola", List.of(salamePiccante));
        Pizza crostino = new Pizza("Prosciutto", List.of(prosciutto, mozzarella));
        Pizza tonnoCipolla = new Pizza("Tonno e cipolla", List.of(tonno, cipolla));

//        itemsService.saveItems(acqua);
//        itemsService.saveItems(acquaFrizzante);
//        itemsService.saveItems(cocaCola);
//        itemsService.saveItems(limonata);
//        itemsService.saveItems(birraMedia );
//        itemsService.saveItems(vinoRosso);
//        itemsService.saveItems(vinoBianco);
//
//        itemsService.saveItems(americana);
//        itemsService.saveItems(capricciosa);
//        itemsService.saveItems(diavola);
//        itemsService.saveItems(crostino);
//        itemsService.saveItems(tonnoCipolla);
        try {
//            itemsService.findByIdAndDelete(1);

//            itemsService.filterByNameStartWith("P").forEach(System.out::println);
//            itemsService.filterByPrice(6.00).forEach(System.out::println);
//            itemsService.findAndDeleteByPrice(0.0);
//            Toppings toppingFromDB = itemsService.findToppingByName("mozzarella");
//
            List<Items> elementiDalDB = itemsService.filterByNameStartWith("PROSCIUTTO");
            System.out.println("ELEMENTI DAL DB PER NOME  " + elementiDalDB);
          
        } catch (NotFoundException ex) {
            log.error(ex.getMessage());
        }


    }
}
