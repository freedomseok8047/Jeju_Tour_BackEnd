package com.backend.jejutour_server.service;

import com.backend.jejutour_server.dto.AccomByGpsDto;
import com.backend.jejutour_server.entity.AccomEntity;
import com.backend.jejutour_server.entity.TourEntity;
import com.backend.jejutour_server.repository.AccomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccomServiceImpl implements AccomService {

    @Autowired
    private AccomRepository accomRepository;

    @Override
    public List<AccomEntity> getAccomDtl(Long accomId) {
        List<AccomEntity> accomList = accomRepository.findByAccomId(accomId);
        return accomList;
    }

    @Override
    public List<AccomEntity> getAllAccomList() {
        List<AccomEntity> accomList= accomRepository.findAll();
        for (int i = 1 ; i < accomList.size(); i++) {
            System.out.println("Service accom facltNm: " + accomList.get(i));
        }
        return  accomList;
    }

    @Override
    public List<AccomEntity> getitemsRegion2CdValueAccomList(Long itemsRegion2CdValue) {
        List<AccomEntity> accomList = accomRepository.findByItemsRegion2CdValue(itemsRegion2CdValue);
        for (int i = 1; i < accomList.size(); i++) {
            System.out.println("Service accom facltNm: " + accomList.get(i));
        }
        return accomList;
    }

    @Override
    public Page<AccomEntity> findAccomsByGPS(AccomByGpsDto accomByGpsDto, Pageable pageable ) {
        return accomRepository.findAccomsByGPS(accomByGpsDto,pageable);
    }


}