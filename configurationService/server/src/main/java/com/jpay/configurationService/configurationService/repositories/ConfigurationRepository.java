package com.jpay.configurationService.configurationService.repositories;

import com.jpay.configurationService.configurationService.entities.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ConfigurationRepository extends CrudRepository<Configuration, Integer> {

    Page<Configuration> findAll(Pageable pageable);

}