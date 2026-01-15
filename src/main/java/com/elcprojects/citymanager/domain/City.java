package com.elcprojects.citymanager.domain;

import jakarta.persistence.*;

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
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="country")
    private String country;

    @Column(name="details")
    private String details;

    public City() {

    }

    public City(String name, String country, String details) {
        this.name = name;
        this.country = country;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
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
