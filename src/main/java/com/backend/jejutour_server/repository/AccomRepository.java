package com.backend.jejutour_server.repository;

import com.backend.jejutour_server.entity.AccomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccomRepository extends JpaRepository<AccomEntity, Integer> {

    List<AccomEntity> findByRegionNm(String region2cd_label);
}