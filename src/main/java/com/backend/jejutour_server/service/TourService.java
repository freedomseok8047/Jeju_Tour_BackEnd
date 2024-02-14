package com.backend.jejutour_server.service;

import com.backend.jejutour_server.dto.TourByGpsDto;
import com.backend.jejutour_server.entity.TourEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;
import java.util.List;


public interface TourService {

    public List<TourEntity> getTourDtl(Long tourId);

    public List<TourEntity> getAllTourList();

    public List<TourEntity> getItemsRegion2CdValueTourList(Long itemsRegion2CdValue);

    public Page<TourEntity> findToursByGPS( TourByGpsDto tourByGpsDto, Pageable pageable );




}