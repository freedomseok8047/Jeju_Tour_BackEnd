package com.backend.jejutour_server.controller;

import com.backend.jejutour_server.entity.FesEntity;
import com.backend.jejutour_server.entity.ShopEntity;
import com.backend.jejutour_server.service.FesService;
import com.backend.jejutour_server.service.ShopService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Log4j2
@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    ShopService shopService;

    @GetMapping("/shopAllList")
    public List<ShopEntity> ShopList() {
        List<ShopEntity> shopList = shopService.getAllShopList();
        return shopList;
    }
}
