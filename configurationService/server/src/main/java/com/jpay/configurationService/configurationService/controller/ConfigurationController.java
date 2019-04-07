package com.jpay.configurationService.configurationService.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.jpay.configurationService.configurationService.dtos.ConfigurationDTO;
import com.jpay.configurationService.configurationService.dtos.ConfigurationResponseDTO;
import com.jpay.configurationService.configurationService.entities.Configuration;
import com.jpay.configurationService.configurationService.exception.ConfigurationNotFoundException;
import com.jpay.configurationService.configurationService.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ConfigurationController
{
    @Autowired
    ConfigurationService configurationService;

    @RequestMapping(value = "/configurations", method = RequestMethod.GET)
    public  ResponseEntity<List<ConfigurationResponseDTO>> getAllConfigurations(Pageable page)
    {
        List<Configuration> configurations = configurationService.findAllConfigurations(page);
        return new ResponseEntity<>(configurations
                .stream()
                .map(configuration -> ConfigurationResponseDTO.convertToDto(configuration))
                .collect(Collectors.toList()),
                HttpStatus.OK
        );
    }

    @RequestMapping(value = "/configurations/{id}", method = RequestMethod.GET)
    public  ResponseEntity<ConfigurationResponseDTO> getConfigurationById(@PathVariable("id") Integer id)
    {
        return new ResponseEntity<>(ConfigurationResponseDTO
                .convertToDto(configurationService.findConfigurationById(id)),
                HttpStatus.OK
        );
    }

    @RequestMapping(value = "/configurations", method = RequestMethod.POST)
    public ResponseEntity<ConfigurationResponseDTO> createConfiguration(@RequestBody ConfigurationDTO configurationDto)
    {
        Configuration configuration = configurationService.saveConfiguration(configurationDto.convertToObject());
        return new ResponseEntity<>(ConfigurationResponseDTO
                .convertToDto(configuration),
                HttpStatus.CREATED
        );
    }

    @RequestMapping(value = "/configurations/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ConfigurationResponseDTO> updateConfiguration(@PathVariable("id") Integer id, @RequestBody ConfigurationDTO configurationDto)
    {
        Configuration configuration = configurationService.findConfigurationById(id);
        if (configuration == null) {
            return new ResponseEntity(
                    new ConfigurationNotFoundException("Unable to update. Configuration with id " + id + " not found."),
                    HttpStatus.NOT_FOUND
            );
        }
        configuration.setName(configurationDto.getName());
        configuration.setScope(configurationDto.getScope());
        configuration.setType(configurationDto.getType());
        configuration.setValue(configurationDto.getValue());
        
        configurationService.saveConfiguration(configuration);
        return new ResponseEntity<>(ConfigurationResponseDTO.convertToDto(configuration), HttpStatus.OK);
    }

    @RequestMapping(value = "/configurations/{id}", method = RequestMethod.DELETE)
    public void deleteConfiguration(@PathVariable("id") Integer id)
    {
        Configuration configuration = configurationService.findConfigurationById(id);
        if (configuration == null) {
            throw new ConfigurationNotFoundException("Unable to delete. Configuration with id " + id + " not found." +
                    HttpStatus.NOT_FOUND);
        }
        configurationService.deleteConfiguration(id);
    }
}
