package api_testing.users.create.response;

import lombok.Getter;
import lombok.Setter;

@Getter
public class CreateUserResponse {
    @Setter
    private int statusCode;
    private String id;
    private String title;
    private String firstName;
    private String lastName;
    private String picture;
    private String email;
    private String registerDate;
    private String updatedDate;
}
