package payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import payroll.GroceryStore.Address;
import payroll.GroceryStore.GroceryStore;
import payroll.GroceryStore.GroceryStoreRepository;
import payroll.Manager.Manager;
import payroll.Manager.ManagerRepository;
import payroll.Order.OrderRepository;

@Configuration
class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(ManagerRepository ManagerRepository, OrderRepository orderRepository,
			GroceryStoreRepository groceryStoreRepository) {

		return args -> {
			  Address test = new Address("100 Lawrence", "M3C 1B4", "Toronto");
			  groceryStoreRepository.deleteAll();
			  GroceryStore g = new GroceryStore(test);
			  
			  groceryStoreRepository.save(g);
			  System.out.println(g.getId());
			  Address test2 = new Address("101 Lawrence", "M3C 1B4", "Toronto");
			  GroceryStore g2 = new GroceryStore(test2);
			  groceryStoreRepository.save(g2);
			  
			  System.out.println(g2.getId());
			  
			log.info("Preloading " + ManagerRepository.save(new Manager("Bilbo", "Baggins", "burglar", 1)));
			log.info("Preloading " + ManagerRepository.save(new Manager("Frodo", "Baggins", "thief", 3)));

			ManagerRepository.findAll().forEach(Manager -> log.info("Preloaded " + Manager));
			
			  


			// orderRepository.save(new Order("MacBook Pro", Status.COMPLETED, null));
			// orderRepository.save(new Order("iPhone", Status.IN_PROGRESS, null));

			// orderRepository.findAll().forEach(order -> {
			/// log.info("Preloaded " + order);
			// });
		};
	}
}