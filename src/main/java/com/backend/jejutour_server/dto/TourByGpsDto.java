package com.backend.jejutour_server.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestParam;

@Getter @Setter
public class TourByGpsDto {
    private Double lat;
    private Double lnt;
    private Double radius;
}
