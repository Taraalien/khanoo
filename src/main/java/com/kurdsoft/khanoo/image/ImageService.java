package com.kurdsoft.khanoo.image;


import com.kurdsoft.khanoo.common.exceptions.NotFound;
import com.kurdsoft.khanoo.houseproperty.House;
import com.kurdsoft.khanoo.houseproperty.IHouseService;
import com.kurdsoft.khanoo.realestate.IRealEstateService;
import com.kurdsoft.khanoo.realestate.RealEstate;
import com.kurdsoft.khanoo.region.IReginService;
import com.kurdsoft.khanoo.region.Region;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Data
public class ImageService implements IImageService{
    private final ImageRep rep;
    private final IHouseService houseService;
    private final IRealEstateService realEstateService;
    @Override
    public Image save(Image image) {
        Long realEstateId=image.getRealEstate().getId();
        Long houseId=image.getHouse().getId();
        RealEstate realEstate=realEstateService.getById(realEstateId);
        House house=houseService.getById(houseId);
        image.setRealEstate(realEstate);
        image.setHouse(house);
        return rep.save(image);
    }

    @Override
    public Image update(Image image) {
        Image lastItem=getById(image.getId());
       lastItem.setImage(image.getImage());
        Long houseId=image.getHouse().getId();
        Long realEstateId=image.getRealEstate().getId();
        RealEstate realEstate=realEstateService.getById(realEstateId);
        House house=houseService.getById(houseId);
        image.setRealEstate(realEstate);
        image.setHouse(house);
        return rep.save(image);
    }

    @Override
    public void delete(Long id) {
        rep.deleteById(id);
    }

    @Override
    public Image getById(Long id) {
        Optional<Image> optionalImage=rep.findById(id);
        if(!optionalImage.isPresent()){
            throw new NotFound("Not Found");
        }

        return optionalImage.get();
    }

    @Override
    public List<Image> getAllByRealEstateId(Long realEstateId) {
        RealEstate realEstate=realEstateService.getById(realEstateId);
        List<Image>  imageList=rep.findAllByRealEstate(realEstate);
        return imageList;
    }

    @Override
    public List<Image> getAllByHousesId(Long houseId) {
        House house=houseService.getById(houseId);
        List<Image>  imageList=rep.findAllByHouse(house);
        return imageList;
    }
}
