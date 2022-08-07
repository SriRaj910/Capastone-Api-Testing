package api_testing.posts.createAndDelete;

import api_testing.posts.PostsClient;
import api_testing.posts.create.CreatePostResponse;
import api_testing.posts.create.Post;
import api_testing.posts.services.PostServices;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateDelete {
    private PostsClient postsClient;
    private PostServices postsService;

    @BeforeClass
    public void beforeClass(){
        postsService = new PostServices();
        postsClient = new PostsClient();
    }

    @Test(priority = 4)
    public void createAndDeletePost(){
        Post body = new Post.Builder().build();
        CreatePostResponse postResponse = postsService.createPost(body);
        postResponse.assertPost(body);
        String id = postResponse.getId();
        Response response = postsClient.deletePost(id);
        response
                .then()
                .statusCode(200);
    }
}
