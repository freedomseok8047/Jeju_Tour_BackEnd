package com.backend.jejutour_server.service;

import com.backend.jejutour_server.entity.FesEntity;
import com.backend.jejutour_server.entity.TourEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FesService {
    public List<FesEntity> getAllFesList();

    public List<FesEntity> getitemsRegion2CdValueFesList(Long itemsRegion2CdValue);

    public Page<FesEntity> findFesByGPS(Double lat, Double lnt, Pageable pageable);
}