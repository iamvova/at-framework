package api;

import io.restassured.response.Response;
import org.testng.Assert;
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
    String apiToken = "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";
    String username = properties.getProperty("LOGIN");
    String mainRepoName = "at-test";
    String mainRepoName1 = "at-test1";
    String mainRepoName2 = "at-test2";

    String newRepoName = UUID.randomUUID().toString().substring(2, 10);


    @DataProvider
    private Object[][] addProvider(){
        int n = 3;
        int m = 3;
        Object[][] res = new Object[n][m];
        res[0] = new Object[]{ mainRepoName + newRepoName, "My new test repository.", false};
        res[1] = new Object[]{ mainRepoName1 + newRepoName, "My second test repository.", false};
        res[2] = new Object[]{ mainRepoName2 + newRepoName, "My last test repository.", true};
        return res;
    }

    @BeforeTest
    void initProperties()  {
        try (Reader reader = new FileReader("src/main/resources/application.properties")) {
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test(dataProvider = "addProvider")
    void crudRestAssuredTest(String req, String desc, Boolean isPrivate) {
        String requestBody = "{ \"name\": \"" + req + "\", \"description\": \""+desc+"\", \"private\": "+isPrivate+" }";
        String updateRequestBody = "{ \"name\": \"" + req+"1"+ "\", \"description\": \"New desc\", \"private\": "+isPrivate+" }";
        //create
        Response response = given()
                .header("Authorization", "Bearer " + apiToken)
                .contentType("application/json")
                .accept("application/json")
                .body(requestBody)
                .log().all()
                .when().post(bodyApi + "user/repos");

        Assert.assertEquals(response.statusCode(), 201);
        String resName = response.body().jsonPath().getString("name");

        //put
        Response newResponse = given()
                .header("Authorization", "Bearer " + apiToken)
                .contentType("application/json")
                .accept("application/json")
                .body(updateRequestBody)
                .log().all()
                .when().patch(bodyApi + "repos/vova-at/"+ resName);

        Assert.assertEquals(newResponse.statusCode(), 200);
        String newResName = newResponse.body().jsonPath().getString("name");

        //delete
        given()
                .header("Authorization", "Bearer " + apiToken)
                .accept("application/json")
                .log().all()
                .when().delete(bodyApi + "repos/vova-at/" + newResName)
                .then().assertThat().statusCode(204);
    }

}
