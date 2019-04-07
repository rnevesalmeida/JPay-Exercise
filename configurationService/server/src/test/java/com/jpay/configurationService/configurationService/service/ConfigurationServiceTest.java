package com.jpay.configurationService.configurationService.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigurationServiceTest {

    @Autowired
    ConfigurationService configurationService;

    @MockBean
    private RestTemplate template;

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