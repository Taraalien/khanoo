package com.kurdsoft.khanoo.image;

import com.kurdsoft.khanoo.houseproperty.HouseMapper;
import com.kurdsoft.khanoo.realestate.RealEstateMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {RealEstateMapper.class, HouseMapper.class})
public interface ImageMapper {

    Image toImage(ImageDTO imageDTO);
    ImageDTO toImageDTO(Image image);
    List<Image> toImageList(List<ImageDTO> imageDTOS);
    List<ImageDTO> toImageDTOList(List<Image> images);
}
