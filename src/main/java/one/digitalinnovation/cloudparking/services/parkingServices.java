package one.digitalinnovation.cloudparking.services;

import one.digitalinnovation.cloudparking.exception.parkingNotFoundException;
import one.digitalinnovation.cloudparking.model.parking;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class parkingServices {

    private static Map<String, parking> parkingMap = new HashMap<String, parking>();

    static {
        var id1 = getUUID();
        var id2 = getUUID();
        var id3 = getUUID();
        parking parking1 = new parking(id1,"DMS - 1110", "SC" , "CELTA" , "PRETO");
        parking parking2 = new parking(id2,"DMS - 1111", "SP" , "GOL" , "BRANCO");
        parking parking3 = new parking(id3,"DMS - 1112", "RJ" , "ONIX" , "PRATA");
        parkingMap.put( id1, parking1);
        parkingMap.put( id2, parking2);
        parkingMap.put( id3, parking3);
    }

    public List<parking> findAll(){
        return parkingMap.values().stream().collect(Collectors.toList());

    }

    private static String getUUID() {

        return UUID.randomUUID().toString().replace("-", "");
    }

    public parking findById(String id) {
        parking parking = parkingMap.get(id);
        if(parking == null){
            throw new parkingNotFoundException(id);
        }
        return parkingMap.get(id);
    }

    public parking create(parking parkingCreate) {
        String uuid = getUUID();
        parkingCreate.setId(getUUID());
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingMap.put(uuid, parkingCreate);
        return parkingCreate;
    }

    public void delete(String id) {
        findById(id);
        parkingMap.remove(id);
    }

    public parking update(String id, parking parkingCreate) {
        parking parking = findById(id);
        parking.setColor(parkingCreate.getColor());
        parkingMap.replace(id , parking);
        return parking;
    }

    public parking exit(String id) {
        //Recuperar o estacionado
        //Atualizar a data da saida
        // Calcular o valor

        return null;
    }
}
