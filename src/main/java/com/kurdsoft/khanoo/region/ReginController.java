package com.kurdsoft.khanoo.region;

import com.kurdsoft.khanoo.houseproperty.House;
import com.kurdsoft.khanoo.houseproperty.HouseDTO;
import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/regin/")
public class ReginController {

    private final IReginService service;
    private ReginMapper reginMapper;

    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody RegionDTO dto){
        Region region=reginMapper.toRegion(dto);
        service.save(region);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody RegionDTO dto){
        Region region=reginMapper.toRegion(dto);
        service.update(region);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/v1/{id}")
    public ResponseEntity<RegionDTO> getById(@PathVariable Long id){
        Region region=service.getById(id);
        RegionDTO regionDTO=reginMapper.toReginDto(region);
        return ResponseEntity.ok(regionDTO);

    }

    @Timed("regin.getAll")
    @GetMapping("/v1")
    public ResponseEntity<List<RegionDTO>> getAll(){
        List<Region>regions=service.getAll();
        List<RegionDTO> regionDTOList=reginMapper.toReginDtos(regions);
        return ResponseEntity.ok(regionDTOList);
    }


    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
