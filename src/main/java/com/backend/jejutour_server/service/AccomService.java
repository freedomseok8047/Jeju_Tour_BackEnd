package com.backend.jejutour_server.service;

import com.backend.jejutour_server.dto.AccomByGpsDto;
import com.backend.jejutour_server.entity.AccomEntity;
import com.backend.jejutour_server.entity.TourEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AccomService {

    public List<AccomEntity> getAccomDtl(Long accomId);

    public List<AccomEntity> getAllAccomList();

    public List<AccomEntity> getitemsRegion2CdValueAccomList(Long itemsRegion2cdValue);

    public Page<AccomEntity> findAccomsByGPS(AccomByGpsDto accomByGpsDto, Pageable pageable );

}