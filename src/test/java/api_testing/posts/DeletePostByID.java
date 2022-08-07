package api_testing.posts;

import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeletePostByID {
    private PostsClient postsClient;

    @BeforeClass
    public void beforeClass(){
        postsClient=new PostsClient();
    }
    @Test(priority = 3)
    public void deletePost(){
        String id = "62efe6fc84633d4a8c411251";   //post id is required here
        Response response = postsClient.deletePost(id);
        response
                .then()
                .statusCode(200);


    }
}
