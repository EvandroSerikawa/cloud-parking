package one.digitalinnovation.cloudparking.controller;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class parkingControllerTestIT {

    @LocalServerPort
    private int randomPort;

    @BeforeEach
    public void setUpTest(){
        System.out.println(randomPort);
        RestAssured.port = randomPort;
    }


    @Test
    void whenfindAllThenCheckResult() {
        RestAssured.given()
                .when()
                .get()
                .then()
                .body("license[0]" , Matchers.equalTo("DMS-1111"));


    }

    @Test
    void create() {
    }
}