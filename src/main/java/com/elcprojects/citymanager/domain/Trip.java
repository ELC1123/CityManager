package com.elcprojects.citymanager.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
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
    @NotNull(message = "Start date cannot be empty!")
    private LocalDate startDate;

    @Column(name="endDate")
    @NotNull(message = "End date cannot be empty!")
    private LocalDate endDate;

    @Column(name="rating")
    @NotNull(message = "Rating is required")
    private Integer rating;

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
