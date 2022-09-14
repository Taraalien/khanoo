package com.kurdsoft.khanoo.houseproperty;


import com.kurdsoft.khanoo.common.exceptions.NotFound;
import com.kurdsoft.khanoo.realestate.IRealEstateService;
import com.kurdsoft.khanoo.realestate.RealEstate;
import com.kurdsoft.khanoo.region.IReginService;
import com.kurdsoft.khanoo.region.Region;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Data
public class HouseService implements IHouseService {

    private final HouseRepository repository;
    private final IReginService reginService;
    private final IRealEstateService realEstateService;
    @Override
    public House save(House house) {
        Long realEstateId=house.getRealEstate().getId();
        Long regionId=house.getRegion().getId();
        RealEstate realEstate=realEstateService.getById(realEstateId);
        Region region=reginService.getById(regionId);
        house.setRealEstate(realEstate);
        house.setRegion(region);
        return repository.save(house);
    }

    @Override
    public House update(House house) {
        House lastItem=getById(house.getId());
        lastItem.setAddress(house.getAddress());
        lastItem.setBedrooms(house.getBedrooms());
        lastItem.setDescription(house.getDescription());
        lastItem.setHouseType(house.getHouseType());
        lastItem.setGarage(house.getGarage());
        lastItem.setFixPrice(house.getFixPrice());
        lastItem.setLocation(house.getLocation());
        lastItem.setParkingSpace(house.getParkingSpace());
        lastItem.setFloor(house.getFloor());
        lastItem.setPricePerMeter(house.getPricePerMeter());
        lastItem.setType(house.getType());
        lastItem.setRentPrice(house.getRentPrice());
        lastItem.setMortgagePrice(house.getMortgagePrice());
        lastItem.setYear(house.getYear());

        Long realEstateId=house.getRealEstate().getId();
        Long regionId=house.getRegion().getId();
        RealEstate realEstate=realEstateService.getById(realEstateId);
        Region region=reginService.getById(regionId);
        lastItem.setRegion(region);
        lastItem.setRealEstate(realEstate);
        return repository.save(lastItem);
    }

    @Override
    public void delete(Long id) {

        Optional<House>optionalHouse=repository.findById(id);
        if(!optionalHouse.isPresent()){
            throw new NotFound("Not Found");
        }
        repository.deleteById(id);
    }

    @Override
    public House getById(Long id) {
        Optional<House>optionalHouse=repository.findById(id);
        if(!optionalHouse.isPresent()){
            throw new NotFound("Not Found");
        }

        return optionalHouse.get();
    }

    @Override
    public List<House> getAll() {
        return (List<House>)repository.findAll();
    }

    @Override
    public List<House> getAllByRealEstateId(Long realEstateId) {
        RealEstate realEstate=realEstateService.getById(realEstateId);
        List<House>  houseList=repository.findAllByRealEstate(realEstate);
        return houseList;
    }


    @Override
    public List<House> getAllByRegionId(Long regionId) {
        Region region=reginService.getById(regionId);
        List<House> houseList=repository.findAllByRegion(region);
        return houseList;
    }

    @Override
    public Page<House> paging(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page,size, Sort.by("id").descending()));
    }
}
