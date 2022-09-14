package com.kurdsoft.khanoo.region;

import com.kurdsoft.khanoo.common.base.BaseDTO;
import com.kurdsoft.khanoo.city.CityDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RegionDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = true)
    private String name;

    @ApiModelProperty(required = true,hidden = true)
    private CityDTO cityDTO;

}
