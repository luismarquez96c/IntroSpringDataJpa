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

			Address juanAddressOne = new Address();
			juanAddressOne.setCountry("El Salvador");
			juanAddressOne.setAddress("Casa 123, Calle Principal Col. Y, San Salvador");

			Address juanAddressTwo = new Address();
			juanAddressTwo.setCountry("Honduras");
			juanAddressTwo.setAddress("Casa 654, Calle Principal Col. ABC, Tegucigalpa");

			juan.setAddresses(List.of(juanAddressOne, juanAddressTwo));

			customerCrudRepository.save(juan);

		};
	}


}
