import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SampleTests {
    @Test
    public void shouldGetAllUsers() {
        given()
                .header("app-id", "62ec52e349dc977737dae934")
                .when()
                .get("https://dummyapi.io/data/v1/user")
                .then()
                .statusCode(200)
                .body("data", Matchers.hasSize(20))
                .body("data", Matchers.hasItem(Matchers.hasEntry("title", "mrs")))
                .log().body();

    }

    @Test
    public void shouldCreateUser() {
        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("app-id", "62ec52e349dc977737dae934")
                .body("{\n" +
                        "  \"title\": \"mr\",\n" +
                        "  \"firstName\": \"Rohan\",\n" +
                        "  \"lastName\": \"Patel\",\n" +
                        "  \"picture\": \"https://images.unsplash.com/photo-1472214103451-9374bd1c798e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80\",\n" +
                        "  \"email\": \"suyashsrivastav967@gmail.com\"\n" +
                        "}")
                .when()
                .post("https://dummyapi.io/data/v1/user/create")
                .then()
                .statusCode(200)
                .log().body();


    }

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

    @Test
    public void shouldNotCreateExistingUser(){

            given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("app-id","62ec52e349dc977737dae934")
                    .body("{\n" +
                            "  \"title\": \"mr\",\n" +
                            "  \"firstName\": \"Rohan\",\n" +
                            "  \"lastName\": \"Patel\",\n" +
                            "  \"picture\": \"https://images.unsplash.com/photo-1472214103451-9374bd1c798e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80\",\n" +
                            "  \"email\": \"suyashsrivastav967@gmail.com\"\n" +
                            "}")
                    .when()
                    .post("https://dummyapi.io/data/v1/user/create")
                    .then()
                    .statusCode(400)
                    .log().body();




        }

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
                    .log().body();




    }
}


