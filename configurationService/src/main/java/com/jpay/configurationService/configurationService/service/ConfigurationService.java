package com.jpay.configurationService.configurationService.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.jpay.configurationService.configurationService.entities.Configuration;
import com.jpay.configurationService.configurationService.repositories.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationService {
    private int firstResult = 1;
    private int maxResults = 2;
    @Autowired
    ConfigurationRepository configurationRepository;

    @Transactional
    public List<Configuration> getAllConfigurations()
    {
        List<Configuration> configurations = new ArrayList<>();

        configurationRepository.findAll(PageRequest.of(firstResult, maxResults, Sort.by(Sort.Direction.DESC, "id"))).forEach(configuration -> configurations.add(configuration));
        return configurations;
    }

//    public List<Configuration> getConfigurationsByType(String type)
//    {
//        List<Configuration> configurations = new ArrayList<>();
//        configurationRepository.findAll().forEach(configuration -> configurations.add(configuration));
//        return configurations;
//    }

    public List<Configuration> getConfigurationsByName(String name)
    {
        List<Configuration> configurations = new ArrayList<>();
        configurationRepository.findConfigurationByName(PageRequest.of(firstResult, maxResults, Sort.by(Sort.DEFAULT_DIRECTION)), name);

        return configurations;
    }

    public Configuration getConfigurationById(Integer id)
    {
        return configurationRepository.findById(id).get();
    }

    public Configuration saveConfiguration(Configuration configuration)
    {
        return configurationRepository.save(configuration);
    }

    public void deleteConfiguration(Integer id)
    {
        configurationRepository.deleteById(id);
    }

}
