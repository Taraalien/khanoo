package com.kurdsoft.khanoo.region;

import com.kurdsoft.khanoo.city.City;
import com.kurdsoft.khanoo.houseproperty.House;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReginRep extends PagingAndSortingRepository<Region,Long> {

    List<Region> findAllByCity(City city);
}
