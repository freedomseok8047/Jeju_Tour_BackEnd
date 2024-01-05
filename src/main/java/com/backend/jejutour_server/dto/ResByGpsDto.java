package com.backend.jejutour_server.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResByGpsDto {
    private Double lat;
    private Double lnt;
    private Double radius;
}
