package one.digitalinnovation.cloudparking.controller.mapper;

import one.digitalinnovation.cloudparking.controller.dto.parkingDTO;
import one.digitalinnovation.cloudparking.model.parking;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class parkingMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public parkingDTO parkingDTO( parking parking ){
        return MODEL_MAPPER.map(parking, parkingDTO.class );
    }

    public List<parkingDTO> toParkingDTOList(List<parking> parkingList) {
        return parkingList.stream().map(this::parkingDTO).collect(Collectors.toList());

    }
}
