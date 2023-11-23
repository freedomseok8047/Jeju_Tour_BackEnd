package com.backend.jejutour_server.controller;


import com.backend.jejutour_server.entity.AccomEntity;
import com.backend.jejutour_server.service.AccomService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/accom")
@RequiredArgsConstructor
public class AccomController {

    @Autowired
    private AccomService accomService;

    // 전체 출력
    @GetMapping("/accomAllList")
    public String AccomList(Model model) {
        List<AccomEntity> accomList = accomService.getAllAccomList();
        System.out.println("res facltNm: " + accomList.get(4).toString());

        return accomList.toString();
    }

    // 지역별 출력
    // /campList/지역코드
    @GetMapping("/accomList/{itemsRegion2CdValue}")
    public List<AccomEntity> AccomitemsRegion2CdValueList(@PathVariable("itemsRegion2CdValue") int itemsRegion2CdValue) throws UnsupportedEncodingException {

        // 지역 코드
        String test = "";
        switch(itemsRegion2CdValue){
            case 1 : test = "제주시내"; break;
            case 2 : test = "애월"; break;
            case 3 : test = "한림"; break;
            case 4 : test = "한경"; break;
            case 5 : test = "조천"; break;
            case 6 : test = "구좌"; break;
            case 7 : test = "우도"; break;
            case 8 : test = "추자"; break;
            case 9 : test = "성산"; break;
            case 10 : test = "서귀포시내"; break;
            case 11 : test = "대정"; break;
            case 12 : test = "안덕"; break;
            case 13 : test = "중문"; break;
            case 14 : test = "남원"; break;
            case 15 : test = "표선"; break;
        }
        List<AccomEntity> accomList = accomService.getitemsRegion2CdValueAccomList(test);
        return accomList;
    }


}
