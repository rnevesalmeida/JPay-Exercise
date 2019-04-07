package com.jpay.configurationService.configurationService.repositories;


import com.jpay.configurationService.configurationService.entities.ConfigurationType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ConfigurationTypeRepository extends CrudRepository<ConfigurationType, Integer> {
    @Query(value = "SELECT u FROM configuration_type u WHERE u.name = :name",
            nativeQuery = true)
    ConfigurationType findByName(@Param("name") String name);
}