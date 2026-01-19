package com.elcprojects.citymanager.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="city")
public class City {
    /**
     *  Creates a new city
     *
     * @param id       id number of the city
     * @param name     name of the city
     * @param country  country where the city is in
     * @param details  details of the city
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    @NotBlank(message = "City Name cannot be empty!")
    private String name;

    @Column(name="country")
    private String country;

    @Column(name="details")
    @Size(max = 500, message = "Description is too long!")
    private String details;

    public City() {

    }

    public City(String name, String country, String details) {
        this.name = name;
        this.country = country;
        this.details = details;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
