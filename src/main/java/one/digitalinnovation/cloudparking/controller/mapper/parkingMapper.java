package one.digitalinnovation.cloudparking.controller.mapper;

import one.digitalinnovation.cloudparking.controller.dto.parkingDTO;
<<<<<<< HEAD
import one.digitalinnovation.cloudparking.model.parking;
=======
import one.digitalinnovation.cloudparking.model.Parking;
>>>>>>> 7cbb0e7ea1cb80afc794fe34e6b9b1c6c8f4fff2
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
