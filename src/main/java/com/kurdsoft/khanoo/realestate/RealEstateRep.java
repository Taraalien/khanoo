package com.kurdsoft.khanoo.realestate;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RealEstateRep extends PagingAndSortingRepository<RealEstate,Long> {

    Page<RealEstate> findAll(Pageable pageable);

}
