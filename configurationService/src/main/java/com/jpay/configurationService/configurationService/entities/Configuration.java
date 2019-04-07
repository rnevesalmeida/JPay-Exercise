package com.jpay.configurationService.configurationService.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Configuration
{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String scope;
    private String name;
    private ConfigurationType type;
    private Integer value;

    public Configuration(String scope, String name, ConfigurationType type, Integer value)
    {
        this.scope = scope;
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public Configuration()
    {
    }

    public String getScope() {
        return scope;
    }

    public String getName()
    {
        return name;
    }

    public ConfigurationType getType()
    {
        return type;
    }

    public Integer getValue()
    {
        return value;
    }

    public String toString()
    {
        String result = String.format(
                "Configuration[id=%d, name='%s', type='%s', value='%s']%n",
                id, name, type, value);
        return result;
    }
}
