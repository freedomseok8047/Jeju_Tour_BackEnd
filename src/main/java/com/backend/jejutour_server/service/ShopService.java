package com.backend.jejutour_server.service;

import com.backend.jejutour_server.entity.FesEntity;
import com.backend.jejutour_server.entity.ShopEntity;

import java.util.List;

public interface ShopService {
    public List<ShopEntity> getAllShopList();
    public ShopEntity getShop (int Shopid);
}
