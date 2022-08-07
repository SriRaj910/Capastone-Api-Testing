package api_testing.users;

import api_testing.users.UsersClient;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import api_testing.users.create.User;
import api_testing.users.create.response.CreateUserErrorResponse;

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


        User user = User.builder().title(title).firstName(firstName).lastName(lastName).picture(picture).email(email).build();

        CreateUserErrorResponse errorResponse = usersClient.createUserError(user);

        Assert.assertEquals(errorResponse.getStatusCode(),400);

        errorResponse.assertHasError("email");








    }
}
