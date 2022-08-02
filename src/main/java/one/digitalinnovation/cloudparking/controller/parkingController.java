package one.digitalinnovation.cloudparking.controller;

import one.digitalinnovation.cloudparking.controller.dto.parkingDTO;
import one.digitalinnovation.cloudparking.services.parkingServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinnovation.cloudparking.model.parking;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class parkingController {

    private final parkingServices parkingService;
    private final one.digitalinnovation.cloudparking.controller.mapper.parkingMapper parkingMapper;

    public parkingController(parkingServices parkingService, one.digitalinnovation.cloudparking.controller.mapper.parkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }

    @GetMapping
    public List<parkingDTO> findAll() {
        List<parking> parkingList = parkingService.findAll();
        List<parkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
        return result;
    }

}

