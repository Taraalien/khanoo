package com.kurdsoft.khanoo.realestate;

import org.springframework.data.domain.Page;

import java.util.List;

public interface IRealEstateService {

    RealEstate save(RealEstate realEstate);
    RealEstate update(RealEstate realEstate);
    void delete(Long id);
    RealEstate getById(Long id);
    List<RealEstate>getAll();

    Page<RealEstate> paging(Integer page, Integer size);
}
