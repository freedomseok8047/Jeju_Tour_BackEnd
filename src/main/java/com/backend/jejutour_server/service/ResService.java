package com.backend.jejutour_server.service;

import com.backend.jejutour_server.dto.ResDto;
import com.backend.jejutour_server.entity.ResEntity;

import java.util.List;

public interface ResService {

    public List<ResEntity> getAllCampList();

    public List<ResEntity> getRegionNmResList(String regionNm);

}
