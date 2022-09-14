package com.kurdsoft.khanoo.image;


import com.kurdsoft.khanoo.houseproperty.House;
import com.kurdsoft.khanoo.houseproperty.HouseDTO;
import com.kurdsoft.khanoo.houseproperty.HouseMapper;
import com.kurdsoft.khanoo.houseproperty.IHouseService;
import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/image/")
@AllArgsConstructor
public class ImageController {

    private final IImageService service;
    private ImageMapper mapper;

    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody ImageDTO dto){
        Image image=mapper.toImage(dto);
        service.save(image);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody ImageDTO dto){
        Image image=mapper.toImage(dto);
        service.update(image);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/v1/{id}")
    public ResponseEntity<ImageDTO> getById(@PathVariable Long id){
        Image image=service.getById(id);
        ImageDTO imageDTO=mapper.toImageDTO(image);
        return ResponseEntity.ok(imageDTO);

    }

    @Timed("house.getAll")
    @GetMapping("/v1")
    public ResponseEntity<List<ImageDTO>> getAll(){
        List<Image>images=service.getAll();
        List<ImageDTO> imageDTOS=mapper.toImageDTOList(images);
        return ResponseEntity.ok(imageDTOS);
    }


    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/get-all-by-realestate-id/{realestate_id}")
    public ResponseEntity<List<ImageDTO>> getAllByRealEstateId(@PathVariable Long id){
        List<Image>images=service.getAllByRealEstateId(id);
        List<ImageDTO> imageDTOS=mapper.toImageDTOList(images);
        return ResponseEntity.ok(imageDTOS);
    }

    @GetMapping("/v1/get-all-by-house-id/{house_id}")
    public ResponseEntity<List<ImageDTO>> getAllByHouseId(@PathVariable Long id){
        List<Image>images=service.getAllByHousesId(id);
        List<ImageDTO> imageDTOS=mapper.toImageDTOList(images);
        return ResponseEntity.ok(imageDTOS);
    }

}
