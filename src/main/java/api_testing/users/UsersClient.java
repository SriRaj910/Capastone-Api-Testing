package api_testing.users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import api_testing.users.create.User;
import api_testing.users.create.response.CreateUserErrorResponse;
import api_testing.users.create.response.CreateUserResponse;
import api_testing.users.getAll.GetAllUserResponse;


import static io.restassured.RestAssured.given;

public class UsersClient {

    public CreateUserResponse createUser(User body){
        Response response = create(body);
        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
        createUserResponse.setStatusCode(response.statusCode());
        return createUserResponse;

    }

    public Response create(User body) {
        Response response =
                given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("app-id", "62ec52e349dc977737dae934")
                    .body(body)
                .when()
                    .post("https://dummyapi.io/data/v1/user/create");
        response
                .then()
                .log().body();
        return response;
    }

    public GetAllUserResponse getAllUsers(){
        Response response = given()
                .header("app-id", "62ec52e349dc977737dae934")
                .when()
                .get("https://dummyapi.io/data/v1/user");
        response
                .then()
                    .log().body();

        int statusCode= response.statusCode();
        GetAllUserResponse getAllUserResponse = response.as(GetAllUserResponse.class);
        getAllUserResponse.setStatusCode(statusCode);

        return getAllUserResponse;

    }

    public CreateUserErrorResponse createUserError(User body){
        Response response = create(body);
        CreateUserErrorResponse errorResponse = response.as(CreateUserErrorResponse.class);
        errorResponse.setStatusCode(response.statusCode());
        return errorResponse;

    }
}
