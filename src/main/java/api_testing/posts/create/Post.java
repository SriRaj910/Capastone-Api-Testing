package api_testing.posts.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class Post {
    private String text;
    private String image;
    private String owner;
    private List<String> tags;
    private int likes;

    public Post(Builder builder) {
        this.text = builder.text;
        this.image = builder.image;
        this.likes = builder.likes;
        this.owner = builder.owner;
        this.tags = builder.tags;
    }

    public static class Builder{
        private String text;
        private String image;
        private String owner;
        @JsonProperty("tags")
        private List<String> tags;
        private int likes;
        public Builder(){
            text = "New Post created";
            image = "https://images.unsplash.com/photo-1472214103451-9374bd1c798e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80";
            likes = 0;
            owner = "62ec5c993988eed1745e4997";
            tags = new ArrayList<>();
        }

        public Post build(){
            Post requestBody = new Post(this);
            return requestBody;
        }

    }



}

