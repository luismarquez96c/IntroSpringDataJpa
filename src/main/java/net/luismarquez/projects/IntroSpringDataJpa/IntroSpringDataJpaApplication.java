package net.luismarquez.projects.IntroSpringDataJpa;

import net.luismarquez.projects.IntroSpringDataJpa.persistence.entity.Address;
import net.luismarquez.projects.IntroSpringDataJpa.persistence.entity.Customer;
import net.luismarquez.projects.IntroSpringDataJpa.persistence.repository.AddressCrudRepository;
import net.luismarquez.projects.IntroSpringDataJpa.persistence.repository.CustomerCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class IntroSpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntroSpringDataJpaApplication.class, args);
	}

	@Autowired
	private CustomerCrudRepository customerCrudRepository;

	@Bean
	public CommandLineRunner testOneToOneRelationshipsCommand(){
		return args -> {

			Customer juan = new Customer();
			juan.setName("Juan López");
			juan.setPassword("juan123");
			juan.setUsername("juan123");

			Address juanAddress = new Address();
			juanAddress.setCountry("El Salvador");
			juanAddress.setAddress("Casa 123, Calle Principal Col. Y, San Salvador");
			juan.setAddress(juanAddress);


			Customer ramonHernandez = new Customer();
			ramonHernandez.setName("Ramon Hernández");
			ramonHernandez.setPassword("ramon123");
			ramonHernandez.setUsername("ramon123");

			Address ramonAddress = new Address();
			ramonAddress.setCountry("El Salvador");
			ramonAddress.setAddress("Casa 456, Calle Principal Col. X, San Salvador");
			ramonHernandez.setAddress(ramonAddress);


			Customer luis = new Customer();
			luis.setName("Luis Márquez");
			luis.setPassword("luism123");
			luis.setUsername("luism123");

			Address luisAddress = new Address();
			luisAddress.setCountry("El Salvador");
			luisAddress.setAddress("Casa 456, Calle Principal Col. X, San Salvador");
			luis.setAddress(luisAddress);

			System.out.println("Se guardaron 3 entidades");
			List<Customer> clientes = List.of(juan,ramonHernandez, luis);
//			customerCrudRepository.saveAll(clientes);

		};
	}

	@Bean
	public CommandLineRunner testAddressCrudRepositoryCommand(AddressCrudRepository addressCrudRepository){
		return args -> {
			addressCrudRepository.findAll()
					.forEach(each -> {
						System.out.println(each.getAddress() + " - " + each.getCustomer().getId());
					});
		};
	}

}
