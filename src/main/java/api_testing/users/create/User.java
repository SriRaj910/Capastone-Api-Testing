package api_testing.users.create;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder

public class User {
    private String title;
    private String firstName;
    private String lastName;
    private String picture;
    private String email;


    public User(String title, String firstName, String lastName, String picture, String email){
        this.title=title;
        this.firstName=firstName;
        this.lastName=lastName;
        this.picture=picture;
        this.email=email;
    }

}
