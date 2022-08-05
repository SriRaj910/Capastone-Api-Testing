package users.create;

public class CreateUserRequestBody {
    private String title;
    private String firstName;
    private String lastName;
    private String picture;
    private String email;

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPicture() {
        return picture;
    }

    public String getEmail() {
        return email;
    }

    public CreateUserRequestBody(String title, String firstName, String lastName, String picture, String email){
        this.title=title;
        this.firstName=firstName;
        this.lastName=lastName;
        this.picture=picture;
        this.email=email;
    }
}
