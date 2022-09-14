package com.kurdsoft.khanoo.houseproperty;


import com.kurdsoft.khanoo.common.base.BaseEntity;
import com.kurdsoft.khanoo.image.Image;
import com.kurdsoft.khanoo.realestate.RealEstate;
import com.kurdsoft.khanoo.region.Region;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_house")
@Data
@Audited
public class House extends BaseEntity {


    @NotNull
    @Column(name = "description")
    private String description;

    @Column(name = "fixprice")
    private  Integer fixPrice;

    @NotNull
    @Column(name = "housetype")
    @Enumerated(EnumType.STRING)
    private HouseType houseType;

    @NotNull
    @Column(name = "parkingspace")
    private Boolean parkingSpace;

    @NotNull
    @Column(name = "garage")
    private Boolean garage;

    @NotNull
    @Column(name = "bedrooms")
    private Integer bedrooms;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "ifrent")
    private Double rentPrice;

    @Column(name = "ifmortgage")
    private Double mortgagePrice;

    @Column(name = "floor")
    private String floor;

    @NotNull
    @Column(name = "pricemeter")
    private Double pricePerMeter;

    @NotNull
    @Column(name = "year")
    private Integer year;

    @NotNull
    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name ="location")
    private Point<G2D> location;



    @ManyToOne
    @JoinColumn(name ="realestate_id")
    private RealEstate realEstate;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "house",cascade = CascadeType.ALL)
    private List<Image> images;



}
