import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUsersCreatedByMe {
    @Test
    public void getUsersCreatedByMe() {
        given()
                .header("app-id", "62ec52e349dc977737dae934")
                .when()
                .get("https://dummyapi.io/data/v1/user?created=1")
                .then()
                .statusCode(200)
                .body("data", Matchers.hasItem(Matchers.hasEntry("title", "mrs")))
                .log().body();
    }
}
