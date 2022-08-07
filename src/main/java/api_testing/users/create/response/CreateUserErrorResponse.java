package api_testing.users.create.response;

import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;


@Getter
public class CreateUserErrorResponse {
    @Setter
    private int statusCode;

    private String error;
    private Data data;

    public void assertHasError(String email){
        Assert.assertEquals(this.statusCode,400);
        Assert.assertEquals(this.error,"BODY_NOT_VALID");
        Assert.assertEquals(this.data.getEmail(),"Email already used");

    }
    @Getter
    public class Data {
        private String email;
    }
}
