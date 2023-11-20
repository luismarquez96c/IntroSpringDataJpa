package net.luismarquez.projects.IntroSpringDataJpa.persistence.repository;

import net.luismarquez.projects.IntroSpringDataJpa.persistence.entity.Customer;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface CustomerCrudRepository extends Repository<Customer, Long> {

    List<Customer> findAll();

    Optional<Customer> findById(Long id);

    Customer save(Customer customer);

    void deleteById(Long id);

}
