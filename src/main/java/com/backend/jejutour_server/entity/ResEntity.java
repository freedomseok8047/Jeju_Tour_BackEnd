package com.backend.jejutour_server.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fnd")
@Getter
@Setter
@ToString
public class ResEntity {
    @Column(columnDefinition = "text")
    private String alltag;
    @Id
    private String contentsid;
    @Column(columnDefinition = "text")
    private String contentscdValue;
    @Column(columnDefinition = "text")
    private String contentscdLabel;
    @Column(columnDefinition = "text")
    private String contentscdRefId;
    @Column(columnDefinition = "text")
    private String title;
    @Column(columnDefinition = "text")
    private String region1cd;
    @Column(columnDefinition = "text")
    private String region2cd;
    @Column(columnDefinition = "text")
    private String region1cdValue;
    @Column(columnDefinition = "text")
    private String region1cdLabel;
    @Column(columnDefinition = "text")
    private String region1cdRefId;
    @Column
    private long region2cdValue;
    @Column(columnDefinition = "text")
    private String region2cdLabel;
    @Column(columnDefinition = "text")
    private String region2cdRefId;
    @Column(columnDefinition = "text")
    private String address;
    @Column(columnDefinition = "text")
    private String roadAddress;
    @Column(columnDefinition = "text")
    private String tag;
    @Column(columnDefinition = "text")
    private String introduction;
    @Column(columnDefinition = "text")
    private String latitude;
    @Column(columnDefinition = "text")
    private String longitude;
    @Column(columnDefinition = "text")
    private String postcode;
    @Column(columnDefinition = "text")
    private String phoneNo;
    @Column(columnDefinition = "text")
    private String repPhotoDescSeo;
    @Column
    private long repPhotoPhotoidPhotoid;
    @Column(columnDefinition = "text")
    private String repPhotoPhotoidImgPath;
    @Column(columnDefinition = "text")
    private String repPhotoPhotoidThumbnailPath;
}
