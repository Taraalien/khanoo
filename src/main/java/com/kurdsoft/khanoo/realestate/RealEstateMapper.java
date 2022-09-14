package com.kurdsoft.khanoo.realestate;


import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RealEstateMapper {

    RealEstate toRealEstate(RealEstateDTO realEstateDTO);
    RealEstateDTO toRealEstateDto(RealEstate realEstate);
    List<RealEstate> toRealEstates(List<RealEstateDTO> dtoList);
    List<RealEstateDTO> toRealEstateDtos(List<RealEstate> realEstateList);
}
