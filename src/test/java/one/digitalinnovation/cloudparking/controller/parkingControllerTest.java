package one.digitalinnovation.cloudparking.controller;

import io.restassured.RestAssured;
import one.digitalinnovation.cloudparking.controller.dto.parkingCreateDTO;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class parkingControllerTest {

    @LocalServerPort
    private int randomPort;

    @BeforeEach
    public void setUpTest(){
        //System.out.println(randomPort);
        RestAssured.port = randomPort;
    }


    @Test
    void whenfindAllThenCheckResult() {
        RestAssured.given()
                .when()
                .get("/parking")
                .then()
                .statusCode(HttpStatus.OK.value());
    }
    @Test
    void whenCreateThenCheckIsCreated(){
        var createDTO = new parkingCreateDTO();
        createDTO.setColor("Branco");
        createDTO.setLicense("DMS-1111");
        createDTO.setModel("GOL");
        createDTO.setState("SP");

        RestAssured.given()
                .when()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(createDTO)
                .post("/parking")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .body("license[0]" , Matchers.equalTo("DMS-1111"))
                .body("color[0]" , Matchers.equalTo("Branco"));

    }
}