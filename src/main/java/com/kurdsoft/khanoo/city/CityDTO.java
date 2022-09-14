package com.kurdsoft.khanoo.city;


import com.kurdsoft.khanoo.common.base.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CityDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private String name;




}
