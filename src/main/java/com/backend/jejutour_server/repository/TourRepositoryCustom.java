package com.backend.jejutour_server.repository;

import com.backend.jejutour_server.dto.TourByGpsDto;
import com.backend.jejutour_server.entity.TourEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TourRepositoryCustom {
    Page<TourEntity> findToursByGPS(TourByGpsDto tourByGpsDto, Pageable pageable);
}
