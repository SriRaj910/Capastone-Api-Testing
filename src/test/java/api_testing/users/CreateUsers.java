package api_testing.users;

import api_testing.users.create.User;
import api_testing.users.create.response.CreateUserResponse;
import api_testing.users.UsersClient;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public class CreateUsers {
    private UsersClient usersClient;
    @BeforeClass
    public void beforeClass(){
        usersClient=new UsersClient();
    }


    @Test
    public void shouldCreateUser() {
        String email=String.format("%s@gmail.com",UUID.randomUUID());
        String title="mr";
        String firstName="Rohan";
        String lastName="patel";
        String picture="https://images.unsplash.com/photo-1472214103451-9374bd1c798e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80";



        //CreateUserRequestBody createUserRequestBody=new CreateUserRequestBody(title,firstName,lastName,picture,email);
        User user = User.builder().title(title).firstName(firstName).lastName(lastName).picture(picture).email(email).build();
        CreateUserResponse createUserResponse = usersClient.createUser(user);

        Assert.assertEquals(createUserResponse.getStatusCode(),200);
        Assert.assertNotNull(createUserResponse.getId());
        Assert.assertEquals(createUserResponse.getEmail(),user.getEmail());



    }

    }

