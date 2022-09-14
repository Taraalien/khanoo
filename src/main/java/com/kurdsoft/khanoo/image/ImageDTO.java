package com.kurdsoft.khanoo.image;

import com.kurdsoft.khanoo.common.base.BaseDTO;
import com.kurdsoft.khanoo.houseproperty.House;
import com.kurdsoft.khanoo.realestate.RealEstate;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ImageDTO extends BaseDTO {

    @ApiModelProperty(required = true, hidden = false)
    private String image;

    @ApiModelProperty(required = true, hidden = false)
    private House house;

    @ApiModelProperty(required = true, hidden = false)
    private RealEstate realEstate;
}
