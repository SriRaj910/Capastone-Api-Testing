import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;

import static io.restassured.RestAssured.given;

public class ShouldNotDuplicateUsers {
    private UsersClient usersClient;
    @BeforeClass
    public void beforeClass(){
        usersClient=new UsersClient();
    }
    @Test
    public void shouldNotCreateExistingUser(){
        String title="mr";
        String firstName="Rohan";
        String lastName="patel";
        String picture="https://images.unsplash.com/photo-1472214103451-9374bd1c798e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80";
        String email="suyashsrivastav967@gmail.com";

        String body =String.format( "{\n" +
                "  \"title\": \""+title+"\",\n" +
                "  \"firstName\": \""+firstName+"\",\n" +
                "  \"lastName\": \""+lastName+"\",\n" +
                "  \"picture\": \""+picture+"\",\n" +
                "  \"email\": \"%s\"\n" +
                "}",email);
        CreateUserRequestBody createUserRequestBody=new CreateUserRequestBody(title,firstName,lastName,picture,email);
        usersClient.createUser(createUserRequestBody)
                .then()
                .statusCode(400)
                .log().body();




    }
}
