package payroll;

import java.util.Date;

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
import payroll.Order.Order;
import payroll.Order.OrderRepository;

@Configuration
class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(ManagerRepository ManagerRepository, OrderRepository orderRepository,
			GroceryStoreRepository groceryStoreRepository) {

		return args -> {

			Address test = new Address("100 Lawrence", "M3C 1B4", "Toronto");

			Manager m1 = new Manager("Bilbo", "Baggins", "burglar", 1);
			Manager m2 = new Manager("Frodo", "Baggins", "thief", 3);

			groceryStoreRepository.save(new GroceryStore(test, "Walmart"));


			Address test2 = new Address("101 Lawrence", "M3C 1B4", "Toronto");
			GroceryStore g2 = new GroceryStore(test2, "Sobeys");
			groceryStoreRepository.save(g2);


			Order o = new Order("MacBook Pro", Status.COMPLETED, new Date());
			o.setG(g2);

			log.info("Preloading " + ManagerRepository.save(m1));

			ManagerRepository.findAll().forEach(Manager -> log.info("Preloaded " + Manager));

			orderRepository.save(o); //

			orderRepository.findAll().forEach(order -> {
				log.info("Preloaded " + order);
			});
		};
	}
}