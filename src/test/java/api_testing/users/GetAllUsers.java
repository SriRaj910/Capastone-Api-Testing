package api_testing.users;



import api_testing.users.getAll.GetAllUserResponse;
import api_testing.users.UsersClient;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllUsers {
    private UsersClient usersClient;
    @BeforeClass
    public void beforeClass(){
        usersClient=new UsersClient();
    }
    @Test
    public void shouldGetAllUsers() {
        GetAllUserResponse getAllUserResponse = usersClient.getAllUsers();


        Assert.assertEquals(getAllUserResponse.getStatusCode(),200);
        Assert.assertEquals(getAllUserResponse.getDataList().size(),20);


}
}
