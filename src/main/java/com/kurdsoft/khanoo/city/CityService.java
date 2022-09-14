package com.kurdsoft.khanoo.city;

import com.kurdsoft.khanoo.common.exceptions.NotFound;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CityService implements ICityService{
    private final CityRep cityRep;
    @Override
    public City save(City city) {

        return cityRep.save(city);
    }

    @Override
    public City update(City city) {
        City lastItem=getById(city.getId());
        lastItem.setName(city.getName());
        return cityRep.save(lastItem);
    }

    @Override
    public void delete(Long id) {
        cityRep.deleteById(id);
    }

    @Override
    public City getById(Long id) {
        Optional<City> optionalCity=cityRep.findById(id);
        if(!optionalCity.isPresent()){
            throw new NotFound("Not Found");
        }

        return optionalCity.get();
    }

    @Override
    public List<City> getAll() {
        return (List<City>) cityRep.findAll();
    }


}
