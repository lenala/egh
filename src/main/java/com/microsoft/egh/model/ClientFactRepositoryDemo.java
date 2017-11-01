package com.microsoft.egh.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientFactRepositoryDemo extends JpaRepository<ClientFact, Long> {

	List<ClientFact> findByLastNameStartsWithIgnoreCase(String lastName);
}
