package com.kurdsoft.khanoo.region;

import com.kurdsoft.khanoo.city.City;
import com.kurdsoft.khanoo.city.ICityService;
import com.kurdsoft.khanoo.common.exceptions.NotFound;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Data
public class ReginService implements IReginService {

    private final ReginRep rep;
    private final ICityService cityService;
    @Override
    public Region save(Region region) {
        Long cityId=region.getCity().getId();
        City city=cityService.getById(cityId);
        region.setCity(city);
        return rep.save(region);

    }

    @Override
    public Region update(Region region) {
        Region lastItem=getById(region.getId());
        lastItem.setName(region.getName());
        Long cityId=region.getCity().getId();
        City city=cityService.getById(cityId);
        lastItem.setCity(city);
        return rep.save(lastItem);
    }

    @Override
    public void delete(Long id) {
        rep.deleteById(id);
    }

    @Override
    public Region getById(Long id) {
        Optional<Region> optionalRegion=rep.findById(id);
        if(!optionalRegion.isPresent()){
            throw new NotFound("Not Found");
        }

        return optionalRegion.get();
    }

    @Override
    public List<Region> getAll() {
        return (List<Region>)rep.findAll();
    }
}
