package com.backend.jejutour_server.service;

import com.backend.jejutour_server.entity.ShopEntity;
import com.backend.jejutour_server.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService{

    @Autowired
    private ShopRepository shopRepository;


    @Override
    public List<ShopEntity> getAllShopList() {
        List<ShopEntity> shopList = shopRepository.findAll();
        for (int i = 1; i < shopList.size(); i++) {

            System.out.println("Service camp facltNm: " + shopList.get(i));
        }
        return shopList;
    }

    @Override
    public ShopEntity getShop(int shopid) {
        return null;
    }


}