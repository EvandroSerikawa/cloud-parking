package one.digitalinnovation.cloudparking.services;

import one.digitalinnovation.cloudparking.model.parking;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class parkingServices {

    private static Map<String, parking> parkingMap = new HashMap<>();

    static {
        var id = getUUID();
        parking parking = new parking(id, "DMS - 111", "SC" , "CELTA" , "PRETO");
        parkingMap.put(id, parking);

    }

    public List<parking> findAll(){
        return parkingMap.values().stream().collect(Collectors.toList());

    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }


}
