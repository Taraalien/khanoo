package com.kurdsoft.khanoo.houseproperty;


import com.kurdsoft.khanoo.common.base.BaseDTO;
import com.kurdsoft.khanoo.realestate.RealEstateDTO;
import com.kurdsoft.khanoo.region.RegionDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class HouseDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private String description;

    @ApiModelProperty(required = false,hidden = false)
    private  Double fixPrice;

    @ApiModelProperty(required = true,hidden = false)
    private HouseType houseType;

    @ApiModelProperty(required = false,hidden = false)
    private Boolean parkingSpace;

    @ApiModelProperty(required = false,hidden = false)
    private Boolean garage;

    @ApiModelProperty(required = true,hidden = false)
    private Integer bedrooms;

    @ApiModelProperty(required = true,hidden = false)
    private Type type;

    @ApiModelProperty(required = false,hidden = false)
    private Double rentPrice;

    @ApiModelProperty(required = false,hidden = false)
    private Double mortgagePrice;

    @ApiModelProperty(required = false,hidden = false)
    private Double mortgageAndRentPrice;

    @ApiModelProperty(required = true,hidden = false)
    private Double pricePerMeter;

    @ApiModelProperty(required = true,hidden = false)
    private Integer year;

    @ApiModelProperty(required = true,hidden = false)
    private String address;

    @ApiModelProperty(required = true,hidden = false)
    private LocationDTO locationDTO;

    @ApiModelProperty(required = true,hidden = false)
    private RealEstateDTO realEstate;

    @ApiModelProperty(required = true,hidden = false)
    private RegionDTO region;



}
