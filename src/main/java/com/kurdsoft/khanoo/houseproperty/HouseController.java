package com.kurdsoft.khanoo.houseproperty;


import com.kurdsoft.khanoo.common.PagingData;
import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/house/")
public class HouseController {

    private final IHouseService service;
    private HouseMapper mapper;

    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody HouseDTO dto){
        House house=mapper.toHouse(dto);
        service.save(house);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody HouseDTO dto){
        House house=mapper.toHouse(dto);
        service.update(house);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/v1/{id}")
    public ResponseEntity<HouseDTO> getById(@PathVariable Long id){
        House house=service.getById(id);
        HouseDTO houseDTO=mapper.toHouseDTO(house);
        return ResponseEntity.ok(houseDTO);

    }

    @Timed("house.getAll")
    @GetMapping("/v1")
    public ResponseEntity<List<HouseDTO>> getAll(){
        List<House>houses=service.getAll();
        List<HouseDTO> houseDTOList=mapper.toHouseDTOS(houses);
        return ResponseEntity.ok(houseDTOList);
    }


    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/get-all-by-realestate-id/{realestate_id}")
    public ResponseEntity<List<HouseDTO>> getAllByRealEstateId(@PathVariable Long id){
        List<House>houses=service.getAllByRealEstateId(id);
        List<HouseDTO> houseDTOList=mapper.toHouseDTOS(houses);
        return ResponseEntity.ok(houseDTOList);
    }

    @GetMapping("/v1/get-all-by-region-id/{region_id}")
    public ResponseEntity<List<HouseDTO>> getAllByRegionId(@PathVariable Long id){
        List<House>houses=service.getAllByRegionId(id);
        List<HouseDTO> houseDTOList=mapper.toHouseDTOS(houses);
        return ResponseEntity.ok(houseDTOList);
    }


    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity<PagingData<HouseDTO>> findAll(@PathVariable Integer page,Integer size){
        Page<House> housePage=service.paging(page,size);
        int totalPage=housePage.getTotalPages();
        List<House> data=housePage.getContent();
        List<HouseDTO> houseDTOS=mapper.toHouseDTOS(data);
     PagingData<HouseDTO> pagingData=new PagingData<>(totalPage,page,houseDTOS);
        return ResponseEntity.ok(pagingData);
    }




}
