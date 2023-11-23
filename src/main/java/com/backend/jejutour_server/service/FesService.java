package com.backend.jejutour_server.service;

import com.backend.jejutour_server.entity.FesEntity;

import java.util.List;

public interface FesService {
    public List<FesEntity> getAllFesList();
    public FesEntity getFes (int Fesid);
}