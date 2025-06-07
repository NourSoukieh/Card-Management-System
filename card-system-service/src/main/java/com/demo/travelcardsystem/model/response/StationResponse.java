package com.demo.travelcardsystem.model.response;

import com.demo.travelcardsystem.constant.Zone;
import lombok.Data;
 
import java.util.Set;
 
@Data
public class StationResponse {
    private String name;
    private Set<Zone> zones;
}