import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


public class githubAuthenticatedTests {


    @Test
    public void verifyNeedAuthorization(){

        given().
                when().
                get("https://api.github.com/user").
                then().statusCode(401);
    }

    @Test
    public void verifyAuthorizationWorks(){

        given().
                auth().preemptive().basic("username", "password").
                when().
                get("https://api.github.com/user").
                then().statusCode(200);
    }
}