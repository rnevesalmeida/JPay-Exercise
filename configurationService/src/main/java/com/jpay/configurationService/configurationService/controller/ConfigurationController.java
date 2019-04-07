package com.jpay.configurationService.configurationService.controller;

import java.util.List;

import com.jpay.configurationService.configurationService.dtos.ConfigurationDTO;
import com.jpay.configurationService.configurationService.dtos.ConfigurationResponseDTO;
import com.jpay.configurationService.configurationService.entities.Configuration;
import com.jpay.configurationService.configurationService.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigurationController
{

    @Autowired
    ConfigurationService configurationService;

    @RequestMapping(value = "/configurations", method = RequestMethod.GET)
    public  ResponseEntity<List<Configuration>> getAllConfigurations()
    {
        return new ResponseEntity<>(configurationService.getAllConfigurations(), HttpStatus.OK);
    }

    @RequestMapping(value = "/configurations/{id}", method = RequestMethod.GET)
    public  ResponseEntity<ConfigurationResponseDTO> getConfigurationById(@PathVariable("id") Integer id)
    {
        return new ResponseEntity<>(ConfigurationResponseDTO.convertToDto(configurationService.getConfigurationById(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/configurations/{name}", method = RequestMethod.GET)
    public  ResponseEntity<List<Configuration>> getConfigurationByName(@PathVariable("name") String name)
    {
        return new ResponseEntity<>(configurationService.getConfigurationsByName(name), HttpStatus.OK);
    }

    @RequestMapping(value = "/configurations", method = RequestMethod.POST)
    public ResponseEntity<ConfigurationResponseDTO> saveConfiguration(@RequestBody ConfigurationDTO configurationResponseDto)
    {
        Configuration configuration = configurationService.saveConfiguration(configurationResponseDto.convertToObject());
        return new ResponseEntity<>(ConfigurationResponseDTO.convertToDto(configuration), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/configurations/{id}", method = RequestMethod.POST)
    public void deleteConfiguration(@PathVariable("id") Integer id)
    {
        configurationService.deleteConfiguration(id);
    }
}
