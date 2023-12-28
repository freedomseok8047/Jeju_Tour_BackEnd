package com.backend.jejutour_server.repository;

import com.backend.jejutour_server.entity.AccomEntity;
import com.backend.jejutour_server.entity.TourEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AccomRepositoryCustom {
    Page<AccomEntity> findAccomsByGPS(Double lat, Double lnt,Double radius, Pageable pageable);
}
