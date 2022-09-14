package com.kurdsoft.khanoo.region;

import com.kurdsoft.khanoo.houseproperty.House;

import java.util.List;

public interface IReginService {

    Region save(Region region);
    Region update(Region region);
    void delete(Long id);
    Region getById(Long id);
    List<Region> getAll();
}
