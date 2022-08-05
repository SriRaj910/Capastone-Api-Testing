import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetPostByID {@Test
public void getPostById(){
    given()
            .header("app-id", "62ec52e349dc977737dae934")
            .when()
            .get("https://dummyapi.io/data/v1/user/62ec5c993988eed1745e4997/post?limit=10\n" +
                    "\n")
            .then()
            .statusCode(200)

            .log().body();

}

}
