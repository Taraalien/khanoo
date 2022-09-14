package com.kurdsoft.khanoo.realestate;


import com.kurdsoft.khanoo.common.exceptions.ConflictException;
import com.kurdsoft.khanoo.common.exceptions.NotFound;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RealEstateService  implements  IRealEstateService{
    private final RealEstateRep rep;
    @Override
    public RealEstate save(RealEstate realEstate) {
        var realEstateList=rep.findAll();
        for(RealEstate r:realEstateList){
                if(r.getName().equals(r.getName())){
                    throw new ConflictException("already been registered");
                }
        }
        return rep.save(realEstate);
    }

    @Override
    public RealEstate update(RealEstate realEstate) {
        var realestates=rep.findAll();
        for(RealEstate r1:realestates){
            if(r1.getName().equals(realEstate.getName())){
                if(r1.getId()==realEstate.getId()){
                    continue;
                }
                throw new ConflictException("already been registered");
            }
        }
        RealEstate lastItem=getById(realEstate.getId());
        lastItem.setName(realEstate.getName());
        lastItem.setActivity(realEstate.getActivity());
        lastItem.setAddress(realEstate.getAddress());
        lastItem.setDescription(realEstate.getDescription());
        lastItem.setPhone(realEstate.getPhone());
        lastItem.setLogo(realEstate.getLogo());
        return rep.save(lastItem);
    }

    @Override
    public void delete(Long id) {
        Optional<RealEstate>optionalRealEstate=rep.findById(id);
        if(!optionalRealEstate.isPresent()){
            throw new NotFound("Not Found");
        }


        rep.deleteById(id);
    }

    @Override
    public RealEstate getById(Long id) {
        Optional<RealEstate>optionalRealEstate=rep.findById(id);
        if(!optionalRealEstate.isPresent()){
            throw new NotFound("Not Found");
        }

        return optionalRealEstate.get();
    }

    @Override
    public List<RealEstate> getAll() {
        return (List<RealEstate>)rep.findAll();
    }

    @Override
    public Page<RealEstate> paging(Integer page, Integer size) {
        return rep.findAll(PageRequest.of(page,size, Sort.by("id").descending()));
    }
}
