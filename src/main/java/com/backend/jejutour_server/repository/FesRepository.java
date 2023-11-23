package com.backend.jejutour_server.repository;

import com.backend.jejutour_server.entity.FesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FesRepository extends JpaRepository<FesEntity,Integer> {
}
