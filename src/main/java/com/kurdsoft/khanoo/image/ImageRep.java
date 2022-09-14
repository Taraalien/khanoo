package com.kurdsoft.khanoo.image;

import com.kurdsoft.khanoo.houseproperty.House;
import com.kurdsoft.khanoo.realestate.RealEstate;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRep extends PagingAndSortingRepository<Image,Long> {

    List<Image>findAllByHouse_Id(Long id);
    List<Image>findAllByRealEstate(RealEstate realEstate);
    List<Image>findAllByHouse(House house);
    List<Image>findAllByHouse_RealEstateId(Long id);
    List<Image>findAllByRealEstateId(Long id);
}
