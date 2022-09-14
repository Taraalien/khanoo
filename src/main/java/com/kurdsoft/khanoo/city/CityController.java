package com.kurdsoft.khanoo.city;


import com.kurdsoft.khanoo.realestate.RealEstate;
import com.kurdsoft.khanoo.realestate.RealEstateDTO;
import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/city/")
public class CityController {

    private final ICityService service;
    private CityMapper mapper;


    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody CityDTO dto){
        City city=mapper.toCity(dto);
        service.save(city);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }



    @GetMapping("/v1/{id}")
    public ResponseEntity<CityDTO> getById(@PathVariable Long id){
        City city=service.getById(id);
        CityDTO dto=mapper.toCityDto(city);
        return ResponseEntity.ok(dto);
    }

    @Timed("city.getAll")
    @GetMapping("/v1")
    public ResponseEntity<List<CityDTO>> getAll(){
        List<City>cityList=service.getAll();
        List<CityDTO>cityDTOList=mapper.toCityDtos(cityList);
        return ResponseEntity.ok(cityDTOList);

    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
