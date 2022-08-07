package api_testing.posts;

import api_testing.posts.create.CreatePostResponse;
import api_testing.posts.services.PostServices;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetPostByID {
    private PostServices postsService;
    @BeforeClass
    public void beforeClass(){
        postsService=new PostServices();
    }
    @Test (priority = 2)
public void getPostById(){
        String id = "62efe48a2378bd5e0fa1613c"; //post id is required here
        //user id 62ec5c993988eed1745e4997
        //post id 62efe48a2378bd5e0fa1613c
        CreatePostResponse postResponse= postsService.getPost(id);

        Assert.assertEquals(postResponse.getStatusCode(),200);

}

}
