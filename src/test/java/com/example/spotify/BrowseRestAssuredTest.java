package com.example.spotify;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class BrowseRestAssuredTest {
    public String token = "BQCUDz3HfO6AjKy6XeDQy5pS4xhD1IpZ3bM4n9B_SrskK6GTQ65Qyl6GkvWFZzC0wtsK8XuEAbxH6pdlPrrNkaI1EBR1JFlWjhhjpCqRboqU8mYAxOV70yEwY1wXXIJK1-kTLCjldrRIOG1cR0GUIi-IOUT2LtTazcJAZZZm119XyVjT58uhJHB--wFfpVUrVF4vnNRwLiiQ8VUGuaZsDBIsIP4fUsWp2j6rUA_iNdySaQvllrcCZEuELC-D8YWawu9BZdGzsUBEsdmnxsf4NW8xOwY";
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://api.spotify.com/v1/me";
    }
    @Test
    public void GetRecommendations() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/recommendations?limit=10&market=ES&seed_artists=4NHQUGzhtTLFvgF5SZesLK&seed_genres=classical%2Ccountry&seed_tracks=0c6xIDDpzE81m2q797ordA");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void GetNewReleases() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/browse/new-releases?country=SE&limit=10&offset=5");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void GetFeaturedPlaylists() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/browse/featured-playlists?country=SE&locale=sv_SE&timestamp=2014-10-23T09%3A00%3A00.000Z&limit=10&offset=5");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void GetAvailableGenreSeeds() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/recommendations/available-genre-seeds");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void GetSeveralBrowseCategories() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/browse/categories?country=SE&locale=sv_SE&limit=10&offset=5");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

}
