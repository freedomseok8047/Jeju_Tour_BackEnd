package com.backend.jejutour_server.service;

import com.backend.jejutour_server.entity.ShopEntity;
import com.backend.jejutour_server.entity.TourEntity;
import com.backend.jejutour_server.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService{

    @Autowired
    private ShopRepository shopRepository;


    @Override
    public List<ShopEntity> getShopDtl(Long shopId) {
        List<ShopEntity> shopList = shopRepository.findByShopId(shopId);
        return shopList;
    }

    @Override
    public List<ShopEntity> getAllShopList() {
        List<ShopEntity> shopList = shopRepository.findAll();
        for (int i = 1; i < shopList.size(); i++) {

            System.out.println("Service shop facltNm: " + shopList.get(i));
        }
        return shopList;
    }

    @Override
    public ShopEntity getShop(int shopid) {
        return null;
    }

    @Override
    public List<ShopEntity> getItemsRegion2CdValueShopList(Long itemsRegion2CdValue) {
        List<ShopEntity> shopList = shopRepository.findByItemsRegion2CdValue(itemsRegion2CdValue);
        for (int i = 1; i < shopList.size(); i++) {
            System.out.println("Service shop facltNm: " + shopList.get(i));
        }
        return shopList;
    }

    @Override
    public Page<ShopEntity> findShopsByGPS(Double lat, Double lnt,Double radius, Pageable pageable) {
        return shopRepository.findShopsByGPS(lat,lnt,radius, pageable);
    }


}