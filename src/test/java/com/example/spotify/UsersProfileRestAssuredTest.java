package com.example.spotify;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


public class UsersProfileRestAssuredTest {
    public String token = "Bearer BQCP2-V32MfMr4GTJpAr3LWn_EGEdphRZJbkCmcpNGeoLo9Bm2rfjkRwaa4VxuCa0McyJ8b6lZV1jyvWO6oCwpAt8KnyPj93Kw8j-P-gr0vCNbgTU2XT39d_qCkg3IV2Ar3PwuwXdO5znziSiDnMrCP2SUUpGAu9PmmLmAWnH_5UCvwsjiA_m-0rTOgYet9tRVtP9deU-RwY0S1UNX0okAOX7QQUKOAqv7pA2GcllqpyvV-C-tE190EMRAza3-fe";
    public String userId = "31bwppxqj44ijzqpuvt3e7ulrq64";
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://api.spotify.com/v1/me";
    }

    @Test(priority = 1)
    public void GetCurrentUsersProfile() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/me");
        response.prettyPrint();
        userId = response.path("id");
        System.out.println("Current user's profile:" + userId);
        response.then().assertThat().statusCode(200);
    }

    @Test(priority = 2)
    public void GetUsersProfile() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/users/31bwppxqj44ijzqpuvt3e7ulrq64");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }
}
