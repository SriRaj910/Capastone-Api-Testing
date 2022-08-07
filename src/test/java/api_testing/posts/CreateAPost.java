package api_testing.posts;

import api_testing.posts.create.CreatePostResponse;
import api_testing.posts.create.Post;
import api_testing.posts.services.PostServices;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public class CreateAPost {

    private PostServices postsService;
    @BeforeClass(groups={"posts"})
    public void beforeClass(){
        postsService = new PostServices();
    }

    @Test(priority = 1)
    public void createAPost(){


        Post body = new Post.Builder().build();
        CreatePostResponse postResponse = postsService.createPost(body);
        postResponse.assertPost(body);



    }






}


