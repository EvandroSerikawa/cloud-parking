package one.digitalinnovation.cloudparking.repository;

import one.digitalinnovation.cloudparking.model.parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface parkingRepository extends JpaRepository<parking, String> {


}
