package com.kurdsoft.khanoo.realestate;

import com.kurdsoft.khanoo.common.base.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class RealEstateDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private String name;

    @ApiModelProperty(required = true,hidden = false)
    private String activity;

    @ApiModelProperty(required = true,hidden = false)
    private String address;

    @ApiModelProperty(required = true,hidden = false)
    private String phone;

    @ApiModelProperty(required = true,hidden = false)
    private String description;

    @ApiModelProperty(required = true,hidden = false)
    private String logo;

}
