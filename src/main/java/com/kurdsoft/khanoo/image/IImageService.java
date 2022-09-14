package com.kurdsoft.khanoo.image;

import com.kurdsoft.khanoo.houseproperty.House;

import java.util.List;

public interface IImageService {
    Image save(Image image);
    Image update(Image image);
    void delete(Long id);
    Image getById(Long id);
    List<Image>getAll();

    List<Image> getAllByRealEstateId(Long realEstateId);
    List<Image> getAllByHousesId(Long houseId);
}
