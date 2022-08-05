package users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import users.create.CreateUserRequestBody;


import static io.restassured.RestAssured.given;

public class UsersClient {

    public Response createUser(CreateUserRequestBody body){
        return  given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("app-id", "62ec52e349dc977737dae934")
                .body(body)
                .when()
                .post("https://dummyapi.io/data/v1/user/create");


    }
    public Response getAllUsers(){
        return given()
                .header("app-id", "62ec52e349dc977737dae934")
                .when()
                .get("https://dummyapi.io/data/v1/user");

    }
}
