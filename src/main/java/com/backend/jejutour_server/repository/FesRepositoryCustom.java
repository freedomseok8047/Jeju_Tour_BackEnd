package com.backend.jejutour_server.repository;

import com.backend.jejutour_server.dto.FesByGpsDto;
import com.backend.jejutour_server.entity.FesEntity;
import com.backend.jejutour_server.entity.TourEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FesRepositoryCustom {
    Page<FesEntity> findFesByGPS(FesByGpsDto fesByGpsDto, Pageable pageable);
}
