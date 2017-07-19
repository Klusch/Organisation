package de.kluge.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.kluge.entities.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	List<Customer> findByLastNameStartsWithIgnoreCase(String lastName);
}