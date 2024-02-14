package com.backend.jejutour_server.controller;


import com.backend.jejutour_server.dto.AccomByGpsDto;
import com.backend.jejutour_server.entity.AccomEntity;
import com.backend.jejutour_server.service.AccomService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/accom")
public class AccomController {

    @Autowired
    private AccomService accomService;

    @GetMapping("/accomDtl/{accomId}")
    public List<AccomEntity> TourList(
            @PathVariable("accomId") Long accomId) {
        try {
            List<AccomEntity> accomList = accomService.getAccomDtl(accomId);
            System.out.println("accomDtl 통신 확인  : " + accomId);
            return accomList;
        } catch(EntityNotFoundException e){
            System.out.println("accomDtl 통신 실패 : " + accomId);
            return null;
        }
    }

    // 전체 출력
    @GetMapping("/accomAllList")
    public List<AccomEntity> AccomList() {
        try {
            List<AccomEntity> accomList = accomService.getAllAccomList();
            System.out.println("accomAllList 호출 성공");
            return accomList;
        } catch (EntityNotFoundException e){
            System.out.println("accomAllList 통신 실패");
            return null;
        }
    }

    // 지역코드로 지역별 출력
    @GetMapping("/accomList/{itemsRegion2CdValue}")
    public List<AccomEntity> AccomItemsRegion2CdValueList(
            @PathVariable("itemsRegion2CdValue") Long itemsRegion2CdValue) {
        try {
            List<AccomEntity> accomList = accomService.getitemsRegion2CdValueAccomList(itemsRegion2CdValue);
            System.out.println("Accom 지역코드별 조회 성공");
            return accomList;
        } catch (EntityNotFoundException e){
            System.out.println("Accom 지역코드별 조회 실패");
            return null;
        }
    }


    @GetMapping("/accomList/accomByGPS")
    @ResponseBody
    public List<AccomEntity> getAccomsByGPS(
//            @RequestParam(value = "lat") Double lat,
//            @RequestParam(value = "lnt") Double lnt,
//            @RequestParam(value = "radius") Double radius,
            AccomByGpsDto accomByGpsDto,
            @RequestParam(value = "page") int page) {
        try {
            Pageable pageable = PageRequest.of( page, 5);
            Page<AccomEntity> Accoms = accomService.findAccomsByGPS(accomByGpsDto, pageable);
            System.out.println("accomByGPS 통신 확인 lat : " + accomByGpsDto.getLat() + " lnt : " + accomByGpsDto.getLnt()
                    + " radius : " + accomByGpsDto.getRadius() + " page : " + page);
            return Accoms.getContent();
        } catch (EntityNotFoundException e) {
            System.out.println("accomByGPS 조회 실패");
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