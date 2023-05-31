package api;

import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
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
    String apiToken = properties.getProperty("api.token");
    String username = properties.getProperty("LOGIN");
    String mainRepoName = "at-test";

    String newRepoName = UUID.randomUUID().toString().substring(2, 10);
    String requestBody = "{ \"name\": \"" + mainRepoName + newRepoName + "\", \"description\": \"My new test repository.\", \"private\": false }";


    @DataProvider
    private Object[][] addProvider(){
        int n = 1;
        int m = 1;
        Object[][] res = new Object[n][m];
        res[0] = new Object[]{requestBody};
        return res;
    }

    @BeforeTest
    void initProperties() throws IOException {
        try (Reader reader = new FileReader("src/main/resources/application.properties")) {
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test(dataProvider = "addProvider")
    void crudRestAssuredTest(String req) {
        //get
        Response response = given()
                .header("Authorization", "Bearer " + apiToken)
                .accept("application/json")
                .log().all()
                .when().get(bodyApi + "user/repos")
                .then().assertThat().statusCode(200).extract().response();
        System.out.println(response.asString());

        //create
        given()
                .header("Authorization", "Bearer " + apiToken)
                .contentType("application/json")
                .accept("application/json")
                .body(req)
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
