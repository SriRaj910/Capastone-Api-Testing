package api_testing.posts.services;

import api_testing.posts.PostsClient;
import api_testing.posts.create.CreatePostResponse;
import api_testing.posts.create.Post;
import io.restassured.response.Response;


public class PostServices {
    public CreatePostResponse createPost(Post body){
        Response response = new PostsClient().createPost(body);
        CreatePostResponse postResponse = response.as(CreatePostResponse.class);
        postResponse.setStatusCode(response.statusCode());
        return postResponse;
    }

    public CreatePostResponse getPost(String id){
        Response response = new PostsClient().getPost(id);
        CreatePostResponse postResponse = response.as(CreatePostResponse.class);
        postResponse.setStatusCode(response.statusCode());
        return postResponse;
    }
}
