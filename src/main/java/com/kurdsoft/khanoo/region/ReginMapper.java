package com.kurdsoft.khanoo.region;


import com.kurdsoft.khanoo.city.CityMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {CityMapper.class})
public interface ReginMapper {
    Region toRegion(RegionDTO regionDTO);
    RegionDTO toReginDto(Region region);
    List<Region> toRegionList(List<RegionDTO> regionDTOList);
    List<RegionDTO> toReginDtos(List<Region> regionList);
}
