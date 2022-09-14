package com.kurdsoft.khanoo.city;


import com.kurdsoft.khanoo.houseproperty.House;
import com.kurdsoft.khanoo.realestate.RealEstate;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRep extends PagingAndSortingRepository<City,Long> {



}
