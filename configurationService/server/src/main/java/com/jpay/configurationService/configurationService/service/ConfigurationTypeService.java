package com.jpay.configurationService.configurationService.service;

import javax.transaction.Transactional;
import com.jpay.configurationService.configurationService.entities.ConfigurationType;
import com.jpay.configurationService.configurationService.repositories.ConfigurationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationTypeService {

    @Autowired
    ConfigurationTypeRepository configurationTypeRepository;

    @Transactional
    public ConfigurationType findConfigurationTypeById(Integer id)
    {
        return configurationTypeRepository.findById(id).get();
    }

    @Transactional
    public ConfigurationType findConfigurationTypeByName(String name)
    {
        return configurationTypeRepository.findByName(name);
    }

    @Transactional
    public void deleteConfigurationType(Integer id)
    {
        configurationTypeRepository.deleteById(id);
    }

}
