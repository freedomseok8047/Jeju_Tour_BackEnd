package com.backend.jejutour_server.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FesByGpsDto {
    private Double lat;
    private Double lnt;
    private Double radius;
}
