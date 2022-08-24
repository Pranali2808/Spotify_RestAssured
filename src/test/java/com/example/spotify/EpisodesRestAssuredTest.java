package com.example.spotify;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


public class EpisodesRestAssuredTest {
    public String token = "BQCUDz3HfO6AjKy6XeDQy5pS4xhD1IpZ3bM4n9B_SrskK6GTQ65Qyl6GkvWFZzC0wtsK8XuEAbxH6pdlPrrNkaI1EBR1JFlWjhhjpCqRboqU8mYAxOV70yEwY1wXXIJK1-kTLCjldrRIOG1cR0GUIi-IOUT2LtTazcJAZZZm119XyVjT58uhJHB--wFfpVUrVF4vnNRwLiiQ8VUGuaZsDBIsIP4fUsWp2j6rUA_iNdySaQvllrcCZEuELC-D8YWawu9BZdGzsUBEsdmnxsf4NW8xOwY";
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://api.spotify.com/v1/me";
    }
    @Test
    public void GetEpisodes() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/episodes/512ojhOuo1ktJprKbVcKyQ?market=ES");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void GetSeveralEpisodes() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/episodes?ids=77o6BIVlYM3msb4MMIL1jH%2C0Q86acNRm6V9GYx55SXKwf&market=ES");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
}
