package com.jpay.configurationService.configurationService.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.jpay.configurationService.configurationService.entities.Configuration;
import com.jpay.configurationService.configurationService.entities.ConfigurationType;
import com.jpay.configurationService.configurationService.repositories.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationService {

    @Autowired
    ConfigurationRepository configurationRepository;
    @Autowired
    ConfigurationService configurationTypeService;

    @Transactional
    public List<Configuration> findAllConfigurations(Pageable pageReq)
    {
        List<Configuration> configurations = new ArrayList<>();

        configurationRepository.findAll(pageReq).forEach(configuration -> configurations.add(configuration));
        return configurations;
    }
    @Transactional
    public Configuration findConfigurationById(Integer id)
    {
        return configurationRepository.findById(id).get();
    }
    @Transactional
    public Configuration saveConfiguration(Configuration configuration)
    {
        return configurationRepository.save(configuration);
    }

    @Transactional
    public void deleteConfiguration(Integer id)
    {
        Configuration configuration = configurationRepository.findById(id).get();

//        configurationRepository.findById(id).orElseThrow(ConfigurationNotFoundException::new);
        configurationRepository.deleteById(id);
    }

}
