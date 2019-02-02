import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class githubTests {


    @Test
    public void verifyStatusCode200(){

        given().
                when().
                get("https://api.github.com/search/repositories?q=user:emmmau&sort=stars&order=desc&page=3&per_page=1").
                then().statusCode(200);

    }

    @Test
    public void verifyStatusCode200WithParams(){

        given().
                param("q", "user:emmmau").
                param("sort", "stars").
                param("order", "desc").
                param("page", "3").
                param("per_page", "1").
                when().
                get("https://api.github.com/search/repositories").
                then().statusCode(200);
    }

    @Test
    public void verifyOwnerLoginValue(){

        given().
                param("q", "user:emmmau").
                param("sort", "stars").
                param("order", "desc").
                param("page", "3").
                param("per_page", "1").
                when().
                get("https://api.github.com/search/repositories").
                then().
                body("items.owner.login", hasItem("emmmau"));
    }

    @Test
    public void verifyHasOneItem(){

        given().
                param("q", "user:emmmau").
                param("sort", "stars").
                param("order", "desc").
                param("page", "3").
                param("per_page", "1").
                when().
                get("https://api.github.com/search/repositories").
                then().
                body("items", hasSize(1));
    }

    @Test
    public void verifyHasMoreThanOneResult(){

        given().
                param("q", "user:emmmau").
                param("sort", "stars").
                param("order", "desc").
                param("page", "3").
                param("per_page", "1").
                when().
                get("https://api.github.com/search/repositories").
                then().
                body("total_count", greaterThan(1));
    }

    @Test
    public void verifyHasTwoItems(){

        given().
                param("q", "user:emmmau").
                param("sort", "stars").
                param("order", "desc").
                param("page", "1").
                param("per_page", "2").
                when().
                get("https://api.github.com/search/repositories").
                then().
                body("items", hasSize(2));
    }
}