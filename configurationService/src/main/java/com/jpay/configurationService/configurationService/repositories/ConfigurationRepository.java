package com.jpay.configurationService.configurationService.repositories;

import java.util.List;

import com.jpay.configurationService.configurationService.entities.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ConfigurationRepository extends CrudRepository<Configuration, Integer> {
    Page<Configuration> findAll(Pageable pageable);
    @Query(value = "SELECT DISTINCT u FROM configuration u WHERE u.name = ?1",
            nativeQuery = true)
    Page<Configuration>  findConfigurationByName(Pageable pageable, String name);
}