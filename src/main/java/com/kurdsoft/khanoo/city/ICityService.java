package com.kurdsoft.khanoo.city;


import com.kurdsoft.khanoo.realestate.RealEstate;

import java.util.List;

public interface ICityService {

    City save(City city);
    City update(City city);
    void delete(Long id);
    City getById(Long id);
    List<City> getAll();


}
