package com.backend.jejutour_server.controller;

import com.backend.jejutour_server.dto.ShopByGpsDto;
import com.backend.jejutour_server.entity.AccomEntity;
import com.backend.jejutour_server.entity.ShopEntity;
import com.backend.jejutour_server.service.ShopService;
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
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping("/shopDtl/{shopId}")
    public List<ShopEntity> ShopList(
            @PathVariable("shopId") Long shopId) {
        try {
            List<ShopEntity> shopList = shopService.getShopDtl(shopId);
            System.out.println("shopDtl 통신 제대로 되나 확인  : " + shopId);
            return shopList;
        } catch(EntityNotFoundException e){
            System.out.println("shopDtl 통신 실패 : " + shopId);
            return null;
        }

    }

    @GetMapping("/shopAllList")
    public List<ShopEntity> ShopList() {
        try {
            List<ShopEntity> shopList = shopService.getAllShopList();
            System.out.println("shopAllList 호출 성공");
            return shopList;
        } catch (EntityNotFoundException e){
            System.out.println("shopAllList 통신 실패");
            return null;
        }
    }

    @GetMapping("/shopList/{itemsRegion2CdValue}")
    public List<ShopEntity> TouritemsRegion2CdValueList(
            @PathVariable("itemsRegion2CdValue") Long itemsRegion2CdValue) {
        try {
            List<ShopEntity> shopList = shopService.getItemsRegion2CdValueShopList(itemsRegion2CdValue);
            System.out.println("Shop 지역코드별 조회 성공");
            return shopList;
        } catch (EntityNotFoundException e){
            System.out.println("Shop 지역코드별 조회 실패");
            return null;
        }
    }

    @GetMapping("/shopList/shopByGPS")
    @ResponseBody
    public List<ShopEntity> getShopsByGPS(
//            @RequestParam(value = "lat") Double lat,
//            @RequestParam(value = "lnt") Double lnt,
//            @RequestParam(value = "radius") Double radius,
            ShopByGpsDto shopByGpsDto,
            @RequestParam(value = "page") int page) {
        try {
            Pageable pageable = PageRequest.of( page, 5);
            Page<ShopEntity> Shops = shopService.findShopsByGPS(shopByGpsDto, pageable);
            System.out.println("shopByGPS 통신 확인 lat : " + shopByGpsDto.getLat() + " lnt : " + shopByGpsDto.getLnt()
                    + " radius : " + shopByGpsDto.getRadius() + " page : " + page);
            return Shops.getContent();
        } catch (EntityNotFoundException e) {
            System.out.println("shopByGPS 조회 실패");
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

