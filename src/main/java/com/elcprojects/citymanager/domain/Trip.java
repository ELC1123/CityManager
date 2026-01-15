package com.elcprojects.citymanager.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="trip")
public class Trip {
    /**
     * Creates a new Trip
     *
     * @param id                id number of the trip
     * @param city              the city where the trip will be held
     * @param startDate         start date of the trip
     * @param endDate           end date of the trip
     * @param rating            rating of the trip
     * @param personalNotes     some personal notes for the traveler
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name="startDate")
    private LocalDate startDate;

    @Column(name="endDate")
    private LocalDate endDate;

    @Column(name="rating")
    private int rating;

    @Column(name="personalNotes")
    private String personalNotes;

    public Trip() {

    }

    public Trip(City city, LocalDate startDate, LocalDate endDate, int rating, String personalNotes) {
        this.city = city;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rating = rating;
        this.personalNotes = personalNotes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getPersonalNotes() {
        return personalNotes;
    }

    public void setPersonalNotes(String personalNotes) {
        this.personalNotes = personalNotes;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", city=" + city +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", rating=" + rating +
                ", personalNotes='" + personalNotes + '\'' +
                '}';
    }
}
