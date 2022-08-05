import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateAPost {

    @Test
    public void createAPost(){
        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("app-id", "62ec52e349dc977737dae934")
                .body("{\n" +
                        "  \"text\": \"New post-rr\",\n" +
                        "  \"image\": \"https://images.unsplash.com/photo-1472214103451-9374bd1c798e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80\",\n" +
                        "  \"likes\": \"0\",\n" +
                        "  \"tags\": [\n" +
                        "    \"hello\",\n" +
                        "    \"how\"\n" +
                        "  ],\n" +
                        "  \"owner\": \"62ec6abd826a1760438d871f\"\n" +
                        "}")
                .when()
                    .post("https://dummyapi.io/data/v1/post/create")
                .then()
                    .statusCode(200)
                    .log().body()
                    .body("text",Matchers.equalTo("New post-rr"));



    }






}


