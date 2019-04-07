package com.jpay.configurationService.configurationService.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.jpay.configurationService.configurationService.entities.Configuration;
import com.jpay.configurationService.configurationService.repositories.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationService {

    @Autowired
    ConfigurationRepository configurationRepository;

    @Transactional
    public List<Configuration> findAllConfigurations(PageRequest pageReq)
    {
        List<Configuration> configurations = new ArrayList<>();

        configurationRepository.findAll(pageReq).forEach(configuration -> configurations.add(configuration));
        return configurations;
    }

    public List<Configuration> findConfigurationsByName(String name, PageRequest pageRequest)
    {
        List<Configuration> configurations = new ArrayList<>();
        configurationRepository.findConfigurationByName(pageRequest, name);

        return configurations;
    }

    public Configuration findConfigurationById(Integer id)
    {
        return configurationRepository.findById(id).get();
    }

    public Configuration saveConfiguration(Configuration configuration)
    {
        return configurationRepository.save(configuration);
    }

    public void deleteConfiguration(Integer id)
    {
//        configurationRepository.findById(id).orElseThrow(ConfigurationNotFoundException::new);
        configurationRepository.deleteById(id);
    }

}
