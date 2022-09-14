package com.kurdsoft.khanoo.city;

import com.kurdsoft.khanoo.houseproperty.HouseMapper;
import com.kurdsoft.khanoo.realestate.RealEstateMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {

        City toCity(CityDTO cityDTO);
        CityDTO toCityDto(City city);

        List<City> toCityList(List<CityDTO> dtoList);
        List<CityDTO> toCityDtos(List<City>cities);
}
