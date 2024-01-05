package com.backend.jejutour_server.controller;


import com.backend.jejutour_server.dto.AccomByGpsDto;
import com.backend.jejutour_server.entity.AccomEntity;
import com.backend.jejutour_server.entity.TourEntity;
import com.backend.jejutour_server.service.AccomService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/accom")
public class AccomController {

    @Autowired
    private AccomService accomService;

    @GetMapping("/accomDtl/{accomId}")
    public List<AccomEntity> TourList(
            @PathVariable("accomId") Long accomId) throws UnsupportedEncodingException{
        try {
            List<AccomEntity> accomList = accomService.getAccomDtl(accomId);
            System.out.println("accomDtl 통신 제대로 되나 확인  : " + accomId);
            return accomList;
        } catch(EntityNotFoundException e){
            System.out.println("accomDtl 통신 실패 : " + accomId);
            return null;
        }

    }

    // 전체 출력
    @GetMapping("/accomAllList")
    public List<AccomEntity> AccomList() {
        List<AccomEntity> accomList = accomService.getAllAccomList();
        System.out.println("accomAllList 호출");
        return accomList;
    }

    // 지역코드로 지역별 출력
    @GetMapping("/accomList/{itemsRegion2CdValue}")
    public List<AccomEntity> AccomItemsRegion2CdValueList(
            @PathVariable("itemsRegion2CdValue") Long itemsRegion2CdValue)
            throws UnsupportedEncodingException {

//            case 11 : test = "제주시내"; break;
//            case 12 : test = "애월"; break;
//            case 13 : test = "한림"; break;

        List<AccomEntity> accomList =
                accomService.getitemsRegion2CdValueAccomList(itemsRegion2CdValue);
        return accomList;
    }
    // 프런트에서 넘오온 위,경도로 데이터 분류

    @GetMapping("/accomList/accomByGPS")
    @ResponseBody
    public List<AccomEntity> getAccomsByGPS(
            @RequestParam(value = "lat") Double lat,
            @RequestParam(value = "lnt") Double lnt,
            @RequestParam(value = "radius") Double radius,
            @RequestParam(value = "page") int page,
            AccomByGpsDto accomByGpsDto
    ) {
        Pageable pageable = PageRequest.of( page, 5);
        Page<AccomEntity> Accoms = accomService.findAccomsByGPS(accomByGpsDto, pageable);

        System.out.println("accomByGPS 통신 확인 lat : " + lat + " lnt : " + lnt + " page : " + page + " radius : " + radius);

        return Accoms.getContent();
    }


}
