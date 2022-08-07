package api_testing.posts;

import api_testing.posts.create.Post;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostsClient {

    public Response createPost(Post body){
        Response response = given()
                .contentType(ContentType.JSON)
                .header("app-id", "62ec52e349dc977737dae934")
                .body(body)
                .when()
                .post("https://dummyapi.io/data/v1/post/create");
        response
                .then()
                .log().body();
        return response;
    }

    public Response getPost(String id){
        return given()
                .header("app-id","62ec52e349dc977737dae934")
                .pathParam("id",id)
                .when()
                .get("https://dummyapi.io/data/v1/post/{id}");
    }

    public Response deletePost(String id){
        return given()
                .header("app-id","62ec52e349dc977737dae934")
                .pathParam("id",id)
                .when()
                .delete("https://dummyapi.io/data/v1/post/{id}");
    }
}
