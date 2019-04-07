package com.jpay.configurationService.configurationService.dtos;

import com.jpay.configurationService.configurationService.entities.Configuration;
import com.jpay.configurationService.configurationService.entities.ConfigurationType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ConfigurationResponseDTO {

    Integer id;
    String scope;
    String name;
    ConfigurationType type;
    Integer value;

    public static ConfigurationResponseDTO convertToDto(Configuration configuration)
    {
        return new ConfigurationResponseDTO(configuration.getId(), configuration.getScope(), configuration.getName(), configuration.getType(), configuration.getValue());
    }
}
