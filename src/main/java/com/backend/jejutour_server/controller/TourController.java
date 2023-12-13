package com.backend.jejutour_server.controller;

import com.backend.jejutour_server.entity.TourEntity;
import com.backend.jejutour_server.service.TourService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

@Log4j2
@RestController
@RequestMapping("/tour")
public class TourController {

    @Autowired
    TourService tourService;


    @GetMapping("/tourAllList")
    public List<TourEntity> TourList() {
        List<TourEntity> tourList = tourService.getAllTourList();
        return tourList;
    }

    @GetMapping("/tourList/{itemsRegion2CdValue}")
    public List<TourEntity> TouritemsRegion2CdValueList(@PathVariable("itemsRegion2CdValue") Long itemsRegion2CdValue) throws UnsupportedEncodingException {

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

        List<TourEntity> tourList = tourService.getItemsRegion2CdValueTourList(itemsRegion2CdValue);
        return tourList;
    }

    @GetMapping("/tourList/tourByGPS/")
    @ResponseBody
    public List<TourEntity> getToursByGPS(
//            @PathVariable("page") Optional<Integer> page,
//            @RequestParam(value = "size",defaultValue = "5") int size,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "lat") Double lat,
            @RequestParam(value = "lnt") Double lnt
    ) {
//        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 10);
        Pageable pageable = PageRequest.of( page, 10);
        Page<TourEntity> Tours = tourService.findToursByGPS(lat, lnt, pageable);
//        Page<TourEntity> Tours = tourService.findToursByGPS(lat, lnt, PageRequest.of( page, 10));

        System.out.println("lat : " + lat + "lnt : " + lnt );

        // Todo getContent() 메서드 사용하면 프런트에서 모델링 필요없음
        return Tours.getContent();
    }

//    @GetMapping(value = {"/admin/items", "/admin/items/{page}"})
//    public String itemManage(ItemSearchDto itemSearchDto, @PathVariable("page") Optional<Integer> page, Model model){
//
//        System.out.println("넘어온 페이지 값 확인: " + page);
//        System.out.println("itemSearchDto 의 getSearchSellStatus 내용 : " + itemSearchDto.getSearchSellStatus());
//        System.out.println("itemSearchDto 의 getSearchCategory 내용 : " + itemSearchDto.getSearchCategory());
//        System.out.println("itemSearchDto 의 getSearchBy 내용 : " + itemSearchDto.getSearchBy());
//
//        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 10);
//        Page<Item> items = itemService.getAdminItemPage(itemSearchDto, pageable);
//
//        model.addAttribute("items", items);
//        model.addAttribute("itemSearchDto", itemSearchDto);
//        model.addAttribute("maxPage", 5);
//
//        return "item/itemMng";
//    }

}