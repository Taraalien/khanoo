package com.kurdsoft.khanoo.houseproperty;

import com.kurdsoft.khanoo.city.City;
import com.kurdsoft.khanoo.realestate.RealEstate;
import com.kurdsoft.khanoo.region.Region;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Geometries;
import org.geolatte.geom.Point;
import org.geolatte.geom.crs.CoordinateReferenceSystems;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;


@Mapper(componentModel = "spring",uses = {RealEstate.class, Region.class})
public interface HouseMapper {




    @Mappings({
            @Mapping(source ="locationDTO",target = "location",qualifiedByName = "LocationDtOToLocation")
    })

     House toHouse(HouseDTO houseDTO);

    @Mappings({
            @Mapping(source = "location",target = "locationDTO",qualifiedByName = "locationToLocationDTO")   })

    HouseDTO toHouseDTO(House house);

    List<HouseDTO> toHouseDTOS(List<House> houseList);
    //List<House> toHouses(List<HouseDTO> houseDTOList);


    @Named("LocationDtOToLocation")
    default Point<G2D> convertLocationDtOToLocation(LocationDTO locationDTO){
        Point<G2D>g2DPoint= Geometries.mkPoint(new G2D(locationDTO.getLng(), locationDTO.getLat()),
                CoordinateReferenceSystems.WGS84);
        return g2DPoint;

    }


    @Named("locationToLocationDTO")
    default LocationDTO  convertlLocationToLocationDTO(Point<G2D> point){
        G2D g2D=point.getPosition();
        LocationDTO locationDTO=new LocationDTO();
        locationDTO.setLat(g2D.getLat());
        locationDTO.setLng(g2D.getLon());
        return locationDTO;

    }




}
