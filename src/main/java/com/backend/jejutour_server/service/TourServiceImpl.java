package com.backend.jejutour_server.service;

import com.backend.jejutour_server.dto.TourByGpsDto;
import com.backend.jejutour_server.entity.AccomEntity;
import com.backend.jejutour_server.entity.TourEntity;
import com.backend.jejutour_server.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class TourServiceImpl implements TourService {

    @Autowired
    private TourRepository tourRepository;


    @Override
    public List<TourEntity> getTourDtl(Long tourId) {
        List<TourEntity> tourList = tourRepository.findByTourId(tourId);
        return tourList;
    }

//    @Transactional(readOnly = true)
//    public ItemFormDto getItemDtl(Long itemId){
//        List<ItemImg> itemImgList = itemImgRepository.findByItemIdOrderByIdAsc(itemId);
//        List<ItemImgDto> itemImgDtoList = new ArrayList<>();
//        for (ItemImg itemImg : itemImgList) {
//            ItemImgDto itemImgDto = ItemImgDto.of(itemImg);
//            itemImgDtoList.add(itemImgDto);
//        }
//
//        Item item = itemRepository.findById(itemId)
//                .orElseThrow(EntityNotFoundException::new);
//        ItemFormDto itemFormDto = ItemFormDto.of(item);
//        itemFormDto.setItemImgDtoList(itemImgDtoList);
//        return itemFormDto;
//    }

    @Override
    public List<TourEntity> getAllTourList() {
        List<TourEntity> tourList = tourRepository.findAll();
        return tourList;
    }

    @Override
    public List<TourEntity> getItemsRegion2CdValueTourList(Long itemsRegion2CdValue) {
        List<TourEntity> tourList = tourRepository.findByItemsRegion2CdValue(itemsRegion2CdValue);
        for (int i = 1; i < tourList.size(); i++) {
            System.out.println("Service tour facltNm: " + tourList.get(i));
        }
        return tourList;
    }

    @Override
    public Page<TourEntity> findToursByGPS(TourByGpsDto tourByGpsDto, Pageable pageable) {
        return tourRepository.findToursByGPS(tourByGpsDto, pageable);
    }
}