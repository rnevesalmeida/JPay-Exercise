package com.jpay.configurationService.configurationService.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Configuration
{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String scope;
    @Column(nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    private ConfigurationType type;
    @Column(nullable = false)
    private Integer value;

    public Configuration(Integer id, String scope, String name, ConfigurationType type, Integer value) {
        this.id = id;
        this.scope = scope;
        this.name = name;
        this.type = type;
        this.value = value;
    }

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

    public Integer getId() {
        return id;
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
