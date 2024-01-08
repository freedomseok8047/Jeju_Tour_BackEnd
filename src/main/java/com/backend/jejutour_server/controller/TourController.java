package com.backend.jejutour_server.controller;

import com.backend.jejutour_server.dto.TourByGpsDto;
import com.backend.jejutour_server.entity.TourEntity;
import com.backend.jejutour_server.service.TourService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/tour")
public class TourController {

    @Autowired
    TourService tourService;

    @GetMapping("/tourDtl/{tourId}")
    public List<TourEntity> TourList(
            @PathVariable("tourId") Long tourId) {
        try {
            List<TourEntity> tourList = tourService.getTourDtl(tourId);
            System.out.println("tourDtl 통신 확인  : " + tourId);
            return tourList;
        } catch (EntityNotFoundException e) {
            System.out.println("tourDtl 통신 실패" + tourId);
            return null;
        }
    }




    @GetMapping("/tourAllList")
    public List<TourEntity> TourList() {
        try {
            List<TourEntity> tourList = tourService.getAllTourList();
            System.out.println("tourAllList 통신 성공");
            return tourList;
        } catch (EntityNotFoundException e){
            System.out.println("tourAllList 통신 실패");
            return null;
        }
    }



    @GetMapping("/tourList/{itemsRegion2CdValue}")
    public List<TourEntity> TouritemsRegion2CdValueList(@PathVariable("itemsRegion2CdValue") Long itemsRegion2CdValue) {
        try {
            List<TourEntity> tourList = tourService.getItemsRegion2CdValueTourList(itemsRegion2CdValue);
            System.out.println("지역코드별 조회 성공");
            return tourList;
        } catch (EntityNotFoundException e){
            System.out.println("지역코드별 조회 실패");
            return null;
        }
    }


    @GetMapping("/tourList/tourByGPS")
    @ResponseBody
    public List<TourEntity> getToursByGPS(
//            @RequestParam(value = "lat") Double lat,
//            @RequestParam(value = "lnt") Double lnt,
//            @RequestParam(value = "radius") Double radius,
            TourByGpsDto tourByGpsDto,
            @RequestParam(value = "page") int page) {
        try {
            Pageable pageable = PageRequest.of(page, 5);
            Page<TourEntity> Tours = tourService.findToursByGPS(tourByGpsDto, pageable);
            System.out.println("tourByGPS 통신 확인 lat : " + tourByGpsDto.getLat() + " lnt : " + tourByGpsDto.getLnt()
                    + " radius : " + tourByGpsDto.getRadius() + " page : " + page);
            return Tours.getContent();
        } catch (EntityNotFoundException e) {
            System.out.println("tourByGPS 조회 실패");
            return null;
        }
    }
}





















// 지역 코드
//            case 11 : test = "제주시내"; break;
//            case 12 : test = "애월"; break;
//            case 13 : test = "한림"; break;
//            case 14 : test = "한경"; break;
//            case 15 : test = "조천"; break;
//            case 16 : test = "구좌"; break;
//            case 17 : test = "성산"; break;
//            case 21 : test = "서귀포시내"; break;
//            case 22 : test = "대정"; break;
//            case 23 : test = "안덕"; break;
//            case 24 : test = "중문"; break;
//            case 25 : test = "남원"; break;
//            case 26 : test = "표선"; break;
//            case 31 : test = "우도"; break;
//            case 32 : test = "추자도"; break;
//            case 33 : test = "마라도"; break;