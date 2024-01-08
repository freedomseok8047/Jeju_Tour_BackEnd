package com.backend.jejutour_server.repository;

import com.backend.jejutour_server.entity.TourEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<TourEntity, Long >, TourRepositoryCustom {


    List<TourEntity> findByItemsRegion2CdValue(Long region2cd_label);

    List<TourEntity> findByTourId(Long tourId);

}