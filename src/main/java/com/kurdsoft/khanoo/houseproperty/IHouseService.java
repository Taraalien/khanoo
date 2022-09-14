package com.kurdsoft.khanoo.houseproperty;

import com.kurdsoft.khanoo.image.Image;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IHouseService {

    House save(House house);
    House update(House house);
    void delete(Long id);
    House getById(Long id);
    List<House> getAll();

    List<House> getAllByRealEstateId(Long realEstateId);
    List<House> getAllByRegionId(Long regionId);
    Page<House> paging(Integer page, Integer size);

}
