package com.backend.jejutour_server.repository;

import com.backend.jejutour_server.dto.AccomByGpsDto;
import com.backend.jejutour_server.entity.AccomEntity;
import com.backend.jejutour_server.entity.TourEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AccomRepositoryCustom {
    Page<AccomEntity> findAccomsByGPS(AccomByGpsDto accomByGpsDto, Pageable pageable);
}
