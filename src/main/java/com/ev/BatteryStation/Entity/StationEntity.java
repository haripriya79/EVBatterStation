package com.ev.BatteryStation.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Table(name = "stations")
public class StationEntity implements Serializable {

    @Id
    @Column(name = "station_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    @Column(name = "station_name")
    private String name;

    @NonNull
    @Column(name = "station_image")
    private String image;

    @NonNull
    @Column(name = "station_pricing")
    private Double pricing;

    @NonNull
    @Column(name = "station_address")
    private String address;



}
