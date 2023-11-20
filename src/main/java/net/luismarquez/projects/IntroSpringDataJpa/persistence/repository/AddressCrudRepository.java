package net.luismarquez.projects.IntroSpringDataJpa.persistence.repository;

import net.luismarquez.projects.IntroSpringDataJpa.persistence.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressCrudRepository extends JpaRepository<Address, Long> {
}
