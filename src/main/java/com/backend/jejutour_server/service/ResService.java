package com.backend.jejutour_server.service;

import com.backend.jejutour_server.dto.ResDto;
import com.backend.jejutour_server.entity.ResEntity;
import com.backend.jejutour_server.entity.TourEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ResService {

    public List<ResEntity> getResDtl(Long resId);

    public List<ResEntity> getAllResList();

    public List<ResEntity> getItemsRegion2CdValueResList(Long itemsRegion2CdValue);

    public Page<ResEntity> findResByGPS(Double lat, Double lnt, Pageable pageable );

}
