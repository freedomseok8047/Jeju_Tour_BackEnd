package com.backend.jejutour_server.controller;

import com.backend.jejutour_server.entity.FesEntity;
import com.backend.jejutour_server.service.FesService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/fes")
public class FesController {

    @Autowired
    FesService fesService;

    @GetMapping("/fesAllList")
    public List<FesEntity> FesList() {
        List<FesEntity> fesList = fesService.getAllFesList();
        return fesList;
    }

}
