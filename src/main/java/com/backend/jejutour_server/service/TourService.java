package com.backend.jejutour_server.service;

import com.backend.jejutour_server.entity.TourEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface TourService {

    public List<TourEntity> getAllTourList();
    public List<TourEntity> getItemsRegion2CdValueTourList(Long itemsRegion2CdValue);

    public Page<TourEntity> findToursByGPS(Double lat, Double lnt, Pageable pageable );



}