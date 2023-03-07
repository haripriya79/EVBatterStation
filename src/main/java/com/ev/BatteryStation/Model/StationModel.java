package com.ev.BatteryStation.Model;

import lombok.*;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class StationModel {
    private Long id;
    private String name;
    private String image;
    private Double pricing;
    private String address;
}
