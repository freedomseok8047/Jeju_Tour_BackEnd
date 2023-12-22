package com.backend.jejutour_server.service;

import com.backend.jejutour_server.entity.FesEntity;
import com.backend.jejutour_server.entity.ShopEntity;
import com.backend.jejutour_server.entity.TourEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ShopService {

    public List<ShopEntity> getShopDtl(Long shopId);
    public List<ShopEntity> getAllShopList();
    public ShopEntity getShop (int Shopid);

    public List<ShopEntity> getItemsRegion2CdValueShopList(Long itemsRegion2CdValue);

    public Page<ShopEntity> findShopsByGPS(Double lat, Double lnt, Pageable pageable );
}


