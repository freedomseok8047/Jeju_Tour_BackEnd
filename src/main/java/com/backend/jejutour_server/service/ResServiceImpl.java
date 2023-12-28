package com.backend.jejutour_server.service;

import com.backend.jejutour_server.entity.ResEntity;
import com.backend.jejutour_server.entity.TourEntity;
import com.backend.jejutour_server.repository.ResRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ResServiceImpl implements ResService{

    @Autowired
    private ResRepository resRepository;

    @Override
    public List<ResEntity> getResDtl(Long resId) {
        List<ResEntity> resList = resRepository.findByFndId(resId);
                return resList;
    }

    @Override
    public List<ResEntity> getAllResList() {
        List<ResEntity> resList = resRepository.findAll();
        for (int i = 1; i < resList.size(); i++) {

            System.out.println("Service res facltNm: " + resList.get(i));
        }
        return resList;
    }

    @Override
    public List<ResEntity> getItemsRegion2CdValueResList(Long itemsRegion2CdValue) {
        List<ResEntity> resList = resRepository.findByItemsRegion2CdValue(itemsRegion2CdValue);
        for (int i = 1; i < resList.size(); i++) {
            System.out.println("Service res facltNm: " + resList.get(i));
        }
        return resList;
    }

    @Override
    public Page<ResEntity> findResByGPS(Double lat, Double lnt,Double radius, Pageable pageable) {
        return resRepository.findResByGPS(lat,lnt,radius, pageable);
    }
}
