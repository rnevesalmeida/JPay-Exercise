package com.jpay.configurationService.configurationService.dtos;

import com.jpay.configurationService.configurationService.entities.Configuration;
import com.jpay.configurationService.configurationService.entities.ConfigurationType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ConfigurationDTO {

    String scope;
    String name;
    ConfigurationType type;
    Integer value;

    public Configuration convertToObject()
    {
        return new Configuration(scope, name, type, value);
    }
}
