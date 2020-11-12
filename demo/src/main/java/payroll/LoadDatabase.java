package payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ManagerRepository ManagerRepository,OrderRepository orderRepository, 
    		GroceryStoreRepository groceryStoreRepository) {

        return args -> {
           log.info("Preloading " + ManagerRepository.save(new Manager("Bilbo", "Baggins", "burglar", 0)));
           log.info("Preloading " + ManagerRepository.save(new Manager("Frodo", "Baggins", "thief", 0)));
            
           ManagerRepository.findAll().forEach(Manager -> log.info("Preloaded " + Manager));
            
            
			/*
			 * Address test = new Address("M1B 1B3", "Toronto", "Ontario", 5, "Lawrence");
			 * groceryStoreRepository.save(new GroceryStore(test));
			 */
           // orderRepository.save(new Order("MacBook Pro", Status.COMPLETED, null));
          //  orderRepository.save(new Order("iPhone", Status.IN_PROGRESS, null));

          //  orderRepository.findAll().forEach(order -> {
          ///    log.info("Preloaded " + order);
          //  });
        };
    }
}