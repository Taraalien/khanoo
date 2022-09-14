package com.kurdsoft.khanoo.realestate;


import com.kurdsoft.khanoo.common.PagingData;
import com.kurdsoft.khanoo.houseproperty.House;
import com.kurdsoft.khanoo.houseproperty.HouseDTO;
import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/realestate/")
@AllArgsConstructor
public class RealEstateController {

    private final IRealEstateService service;
    private RealEstateMapper mapper;


    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody RealEstateDTO dto){
        RealEstate estate=mapper.toRealEstate(dto);
        service.save(estate);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody RealEstateDTO dto){
        RealEstate  realEstate=mapper.toRealEstate(dto);
        service.update(realEstate);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<RealEstateDTO> getById(@PathVariable Long id){
        RealEstate realEstate=service.getById(id);
        RealEstateDTO dto=mapper.toRealEstateDto(realEstate);
        return ResponseEntity.ok(dto);
    }

    @Timed("realEstate.getAll")
    @GetMapping("/v1")
    public ResponseEntity<List<RealEstateDTO>> getAll(){
        List<RealEstate>realEstateList=service.getAll();
        List<RealEstateDTO>realEstateDTOList=mapper.toRealEstateDtos(realEstateList);
        return ResponseEntity.ok(realEstateDTOList);

    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity<PagingData<RealEstateDTO>> findAll(@PathVariable Integer page, Integer size){
        Page<RealEstate> realEstates=service.paging(page,size);
        int totalPage=realEstates.getTotalPages();
        List<RealEstate> data=realEstates.getContent();
        List<RealEstateDTO> realEstateDTOS=mapper.toRealEstateDtos(data);
        PagingData<RealEstateDTO> pagingData=new PagingData<>(totalPage,page,realEstateDTOS);
        return ResponseEntity.ok(pagingData);
    }
}
