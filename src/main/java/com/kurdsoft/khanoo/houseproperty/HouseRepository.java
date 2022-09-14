package com.kurdsoft.khanoo.houseproperty;

import com.kurdsoft.khanoo.city.City;
import com.kurdsoft.khanoo.realestate.RealEstate;
import com.kurdsoft.khanoo.region.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HouseRepository extends PagingAndSortingRepository<House,Long> {

    List<House> findAllByRegion_Id(Long id);
    List<House> findAllByRegion(Region region);
    List<House> findAllByRegion_City_Id(Long id);
    List<House> findAllByRealEstate(RealEstate realEstate);
    Page<House> findAll(Pageable pageable);

}
