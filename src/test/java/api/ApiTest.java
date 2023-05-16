package api;

import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;
import java.util.UUID;

import static io.restassured.RestAssured.given;

public class ApiTest {
    private String bodyApi = "https://api.github.com/";
    Properties properties = new Properties();


    @BeforeTest
    void initProperties() throws IOException {
        try (Reader reader = new FileReader("src/main/resources/application.properties")) {
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    void crudRestAssuredTest() {
        String apiToken = properties.getProperty("api.token");
        String username = properties.getProperty("LOGIN");

        String mainRepoName = "at-test";

        //get
        Response response = given()
                .header("Authorization", "Bearer " + apiToken)
                .accept("application/json")
                .log().all()
                .when().get(bodyApi + "user/repos")
                .then().assertThat().statusCode(200).extract().response();
        System.out.println(response.asString());

        String newRepoName = UUID.randomUUID().toString().substring(2, 10);
        String requestBody = "{ \"name\": \"" + mainRepoName + newRepoName + "\", \"description\": \"My new test repository.\", \"private\": false }";

        //create
        given()
                .header("Authorization", "Bearer " + apiToken)
                .contentType("application/json")
                .accept("application/json")
                .body(requestBody)
                .log().all()
                .when().post(bodyApi + "user/repos")
                .then().assertThat().statusCode(201);


        //delete
        given()
                .header("Authorization", "Bearer " + apiToken)
                .accept("application/json")
                .log().all()
                .when().delete(bodyApi + "repos/" + username + "/" + mainRepoName + newRepoName)
                .then().assertThat().statusCode(204);

    }

}
