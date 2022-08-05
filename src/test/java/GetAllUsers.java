import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;

import static io.restassured.RestAssured.given;

public class GetAllUsers {
    private UsersClient usersClient;
    @BeforeClass
    public void beforeClass(){
        usersClient=new UsersClient();
    }
    @Test
    public void shouldGetAllUsers() {
            usersClient.getAllUsers()
            .then()
                .statusCode(200)
                .body("data", Matchers.hasSize(20))
                .body("data", Matchers.hasItem(Matchers.hasEntry("title", "mrs")))
                 .log().body();

}
}
