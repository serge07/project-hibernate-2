package com.movie.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "country",schema = "movie")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Integer countryId;

    @Column(name = "country")
    private String country;

    @Column(name = "last_update")
    private Timestamp last_update;
}
