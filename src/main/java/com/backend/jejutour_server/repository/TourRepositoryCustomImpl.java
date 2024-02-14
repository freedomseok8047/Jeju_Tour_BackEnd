package com.backend.jejutour_server.repository;

import com.backend.jejutour_server.dto.TourByGpsDto;
import com.backend.jejutour_server.entity.TourEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class TourRepositoryCustomImpl implements TourRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    // 위도 경도 +- 0.02 내의 데이터 조회 범위 예( 32.98, 33.02 / 119.98 , 120.02 )
//    public List<TourEntity> findToursByGPS(Double lat, Double lnt) {
//        String jpql = "SELECT t FROM TourEntity
//        t WHERE t.itemsLatitude
//        BETWEEN :minLat AND :maxLat AND t.itemsLongitude
//        BETWEEN :minLnt AND :maxLnt";
//        TypedQuery<TourEntity> query = entityManager.createQuery(jpql, TourEntity.class);
//        query.setParameter("minLat", lat - 0.05);
//        query.setParameter("maxLat", lat + 0.05);
//        query.setParameter("minLnt", lnt - 0.05);
//        query.setParameter("maxLnt", lnt + 0.05);
//
//        return query.getResultList();
//    }

    // 위도 경도 기준 n Km 내에 있는 데이터 조회하는 Query
    public Page<TourEntity> findToursByGPS(TourByGpsDto tourByGpsDto, Pageable pageable) {
        // 3km를 미터 단위로 변환
//        double radius = 4500; // 4.5km

        String jpql = "SELECT t FROM TourEntity t " +
                "WHERE ST_Distance_Sphere(point(t.itemsLongitude, t.itemsLatitude)," +
                " point(:lnt, :lat)) <= :radius";
        TypedQuery<TourEntity> query = entityManager.createQuery(jpql, TourEntity.class);
        query.setParameter("lat", tourByGpsDto.getLat());
        query.setParameter("lnt", tourByGpsDto.getLnt());
        query.setParameter("radius", tourByGpsDto.getRadius() * 1000);
        // Set pagination parameters
        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());

       List<TourEntity> content = query.getResultList();

       return new PageImpl<>(content);
    }
}
//        .limit(pageable.getPageSize())