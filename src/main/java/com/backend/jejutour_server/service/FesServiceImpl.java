package com.backend.jejutour_server.service;


import com.backend.jejutour_server.dto.FesByGpsDto;
import com.backend.jejutour_server.entity.FesEntity;
import com.backend.jejutour_server.entity.TourEntity;
import com.backend.jejutour_server.repository.FesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FesServiceImpl implements FesService{

    @Autowired
    private FesRepository fesRepository;


    @Override
    public List<FesEntity> getFesDtl(Long fesId) {
        List<FesEntity> fesList = fesRepository.findByFestivalId(fesId);
        return fesList;
    }

    @Override
    public List<FesEntity> getAllFesList() {
        List<FesEntity> fesList = fesRepository.findAll();
        for (int i = 1; i < fesList.size(); i++) {

            System.out.println("Service fes facltNm: " + fesList.get(i));
        }
        return fesList;
    }


    @Override
    public List<FesEntity> getitemsRegion2CdValueFesList(Long itemsRegion2CdValue) {
        List<FesEntity> fesList = fesRepository.findByItemsRegion2CdValue(itemsRegion2CdValue);
        for (int i = 1; i < fesList.size(); i++) {
            System.out.println("Service fes facltNm: " + fesList.get(i));
        }
        return fesList;
    }

    @Override
    public Page<FesEntity> findFesByGPS(FesByGpsDto fesByGpsDto, Pageable pageable) {
        return fesRepository.findFesByGPS(fesByGpsDto, pageable);
    }


}