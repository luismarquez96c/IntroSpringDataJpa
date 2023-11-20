package net.luismarquez.projects.IntroSpringDataJpa;

import net.luismarquez.projects.IntroSpringDataJpa.persistence.entity.Customer;
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
	public CommandLineRunner testQueryMethodCommand(){
		return args -> {

			Customer juan = new Customer();
			juan.setName("Juan López");
			juan.setPassword("juan123");
			juan.setUsername("juan123");

			Customer ramonHernandez = new Customer();
			ramonHernandez.setName("Ramon Hernández");
			ramonHernandez.setPassword("ramon123");
			ramonHernandez.setUsername("ramon123");

			Customer ramonChávez = new Customer();
			ramonChávez.setName("Ramon Chavez");
			ramonChávez.setPassword("ramonc123");
			ramonChávez.setUsername("ramonc123");

			Customer luis = new Customer();
			luis.setName("Luis Márquez");
			luis.setPassword("luism123");
			luis.setUsername("luism123");

			Customer luisCanas = new Customer();
			luisCanas.setName("Luis Cañas");
			luisCanas.setPassword("luisc123");
			luisCanas.setUsername("luisc123");


			System.out.println("Se guardaron 3 entidades");
			List<Customer> clientes = List.of(juan,ramonChávez,ramonHernandez, luis, luisCanas);
			customerCrudRepository.saveAll(clientes);

//			//Pruebas vídeo 1
//			System.out.println("\nProbando query method: searchByUsername");
//			System.out.println(customerCrudRepository.searchByUsername("luism123"));
//
//			System.out.println("\nProbando query method: findByUsername");
//			System.out.println(customerCrudRepository.findByUsername("luisc123"));

			//Pruebas vídeo 2

			System.out.println("\nNombres que contienen la letra O");
			customerCrudRepository.findByNameContaining("o")
					.forEach(System.out::println);


			System.out.println("\nNombres que empiezen con las letras ramon");
			customerCrudRepository.queryByNameStartsWith("ramon")
					.forEach(System.out::println);

			System.out.println("\nNombres que terminan con las letras ez");
			customerCrudRepository.readByNameIsEndingWith("ez")
					.forEach(System.out::println);

			System.out.println("\nNombres que contienen ez y cuyo id sea mayor que 3");
			customerCrudRepository.findByNameContainingAndIdGreaterThanEqualOrderByIdDesc("ez", 3L)
					.forEach(System.out::println);

			System.out.println("\nNombres que contienen ez y cuyo id sea mayor que 3 utilizando JPQL y la anotación @Query");
			customerCrudRepository.findAllByNameAndIdGreaterThan("ez", 3L)
					.forEach(System.out::println);

			System.out.println("\nNombres que contienen ez y cuyo id sea mayor que 3 utilizando SQL Nativo");
			customerCrudRepository.findAllByNameAndIdGreaterThanUsingNativeSQL("ez", 3L)
					.forEach(System.out::println);
		};
	}

}
