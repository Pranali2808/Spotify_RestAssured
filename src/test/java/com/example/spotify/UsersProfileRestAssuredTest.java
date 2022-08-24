package com.example.spotify;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class UsersProfileRestAssuredTest {
    public String token = "BQCUDz3HfO6AjKy6XeDQy5pS4xhD1IpZ3bM4n9B_SrskK6GTQ65Qyl6GkvWFZzC0wtsK8XuEAbxH6pdlPrrNkaI1EBR1JFlWjhhjpCqRboqU8mYAxOV70yEwY1wXXIJK1-kTLCjldrRIOG1cR0GUIi-IOUT2LtTazcJAZZZm119XyVjT58uhJHB--wFfpVUrVF4vnNRwLiiQ8VUGuaZsDBIsIP4fUsWp2j6rUA_iNdySaQvllrcCZEuELC-D8YWawu9BZdGzsUBEsdmnxsf4NW8xOwY";
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
