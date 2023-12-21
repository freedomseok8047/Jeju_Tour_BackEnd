package com.backend.jejutour_server.service;

import com.backend.jejutour_server.entity.AccomEntity;
import com.backend.jejutour_server.entity.TourEntity;
import com.backend.jejutour_server.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourServiceImpl implements TourService {

    @Autowired
    private TourRepository tourRepository;


    @Override
    public Page<TourEntity> getAllTourList(Pageable pageable) {
        return tourRepository.findAll(pageable);
//      Pageable  List<TourEntity> tourList = tourRepository.findAll();
//        for (int i = 1; i < tourList.size(); i++) {
//
//            System.out.println("Service camp facltNm: " + tourList.get(i));
//        }
//        return tourList;
    }

    @Override
    public List<TourEntity> getItemsRegion2CdValueTourList(Long itemsRegion2CdValue) {
        List<TourEntity> tourList = tourRepository.findByItemsRegion2CdValue(itemsRegion2CdValue);
        for (int i = 1; i < tourList.size(); i++) {
            System.out.println("Service tour facltNm: " + tourList.get(i));
        }
        return tourList;
    }

    @Override
    public Page<TourEntity> findToursByGPS(Double lat, Double lnt, Pageable pageable) {
        return tourRepository.findToursByGPS(lat,lnt, pageable);
    }
}