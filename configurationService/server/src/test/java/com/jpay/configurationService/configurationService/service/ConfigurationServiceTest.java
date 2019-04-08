package com.jpay.configurationService.configurationService.service;

import com.jpay.configurationService.configurationService.entities.Configuration;
import com.jpay.configurationService.configurationService.entities.ConfigurationType;
import com.jpay.configurationService.configurationService.repositories.ConfigurationRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigurationServiceTest {

    @Autowired
    ConfigurationService configurationService;

    @MockBean
    private ConfigurationRepository configurationRepository;

    @Before
    public void setUp() {
        Configuration configuration = new Configuration(1,"scope", "name", new ConfigurationType("type1"), 1);

        Mockito.when(configurationRepository.findById(configuration.getId()).get()).thenReturn(configuration);
    }

    @Test
    public void getAllConfigurations() {
    }

    @Test
    public void getConfigurationById() {
    }

    @Test
    public void saveConfiguration() {
    }

    @Test
    public void deleteConfiguration() {
    }
}