package com.jpay.configurationService.configurationService.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Configuration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String scope;
    @Column
    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_type", referencedColumnName = "id")
    private ConfigurationType type;
    @Column
    private Integer value;

    public Configuration(Integer id, String scope, String name, ConfigurationType type, Integer value) {
        this.id = id;
        this.scope = scope;
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public Configuration(String scope, String name, ConfigurationType type, Integer value) {
        this.scope = scope;
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public Configuration() {
    }

    public String toString() {
        String result = String.format(
                "Configuration[id=%d, name='%s', type='%s', value='%s']%n",
                id, name, type, value);
        return result;
    }
}
