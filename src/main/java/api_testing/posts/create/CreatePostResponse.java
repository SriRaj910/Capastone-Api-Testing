package api_testing.posts.create;

import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

import java.util.List;

@Getter
public class CreatePostResponse {
    private String text;
    private String image;
    private User owner;
    private String id;
    private String link;
    private String publishDate;
    private String updatedDate;
    private List<String> tags;
    private int likes;
    @Setter
    private int statusCode;

    public void assertPost(Post body) {
        Assert.assertEquals(this.statusCode,200);
        Assert.assertEquals(this.text,body.getText());
        Assert.assertEquals(this.image,body.getImage());
        Assert.assertEquals(this.owner.id,body.getOwner());
        Assert.assertEquals(this.tags,body.getTags());
        Assert.assertEquals(this.likes,body.getLikes());
    }

    @Getter
    private static class User {
        private String id;
        private String firstName;
        private String lastName;
        private String title;
        private String picture;
    }
}
