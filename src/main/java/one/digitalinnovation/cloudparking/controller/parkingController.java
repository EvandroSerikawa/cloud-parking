package one.digitalinnovation.cloudparking.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import one.digitalinnovation.cloudparking.controller.dto.parkingCreateDTO;
import one.digitalinnovation.cloudparking.controller.dto.parkingDTO;
import one.digitalinnovation.cloudparking.services.parkingServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import one.digitalinnovation.cloudparking.model.parking;

import java.util.List;

@RestController
@RequestMapping("/parking")
@Api(tags = "Parking Controller")
public class parkingController {

    private final parkingServices parkingService;
    private final one.digitalinnovation.cloudparking.controller.mapper.parkingMapper parkingMapper;

    public parkingController(parkingServices parkingService, one.digitalinnovation.cloudparking.controller.mapper.parkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }

    @GetMapping
    @ApiOperation("Find all parkings")
    public ResponseEntity<List<parkingDTO>>findAll() {
        List<parking> parkingList = parkingService.findAll();
        List<parkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<parkingDTO>finById(@PathVariable String id) {
        parking parking = parkingService.findById(id);
        parkingDTO result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<parkingDTO>create(@RequestBody parkingCreateDTO dto) {
            var parkingCreate = parkingMapper.toParkingCreate(dto);
            var parking = parkingService.create(parkingCreate);
            var result = parkingMapper.toParkingDTO(parking);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete (@PathVariable String id) {
        parkingService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<parkingDTO>update(@PathVariable String id , @RequestBody parkingCreateDTO parkingCreateDTO) {
        parking parkingUpdate  = parkingMapper.toParkingCreate(parkingCreateDTO);
        parking parking = parkingService.update(id , parkingUpdate);
        return ResponseEntity.ok(parkingMapper.toParkingDTO(parking));
    }

    @PostMapping("/{id}")
    public ResponseEntity<parkingDTO>exit(@PathVariable String id) {
        parking parking = parkingService.exit(id);
        return ResponseEntity.ok(parkingMapper.toParkingDTO(parking));
    }

}

