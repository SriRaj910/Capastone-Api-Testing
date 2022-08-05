import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeletePostByID {
    @Test
    public void deletePost(){
        given()
                .header("app-id", "62ec52e349dc977737dae934")
                .when()
                .delete("https://dummyapi.io/data/v1/post/62ec861953d58ef8c1838403" )
                .then()
                .statusCode(200)

                .log().body();


    }
}
