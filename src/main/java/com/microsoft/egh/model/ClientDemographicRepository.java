package com.microsoft.egh.model;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClientDemographicRepository extends JpaRepository<ClientDemographic, Long> {
    List<ClientDemographic> findByLastNameStartsWithIgnoreCase(String lastName);
}

