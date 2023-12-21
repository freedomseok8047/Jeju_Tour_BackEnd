package com.backend.jejutour_server.repository;

import com.backend.jejutour_server.entity.ResEntity;
import com.backend.jejutour_server.entity.TourEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ResRepositoryCustom {
    Page<ResEntity> findResByGPS(Double lat, Double lnt, Pageable pageable);
}
