import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SampleTests {
    @Test
    public  void shouldGetAllUsers(){
        given()
                .header("app-id","62ec52e349dc977737dae934")
                .when()
                    .get("https://dummyapi.io/data/v1/user")
                .then()
                    .statusCode(200)
                    .log().body();

    }
}
