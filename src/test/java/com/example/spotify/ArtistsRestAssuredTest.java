package com.example.spotify;
import io.restassured.RestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class ArtistsRestAssuredTest {
    public String token = "BQCUDz3HfO6AjKy6XeDQy5pS4xhD1IpZ3bM4n9B_SrskK6GTQ65Qyl6GkvWFZzC0wtsK8XuEAbxH6pdlPrrNkaI1EBR1JFlWjhhjpCqRboqU8mYAxOV70yEwY1wXXIJK1-kTLCjldrRIOG1cR0GUIi-IOUT2LtTazcJAZZZm119XyVjT58uhJHB--wFfpVUrVF4vnNRwLiiQ8VUGuaZsDBIsIP4fUsWp2j6rUA_iNdySaQvllrcCZEuELC-D8YWawu9BZdGzsUBEsdmnxsf4NW8xOwY";
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://api.spotify.com/v1/me";
    }
    @Test
    public void GetArtist() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void GetArtistsTopTracks() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/top-tracks?market=ES");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void GetArtistsRelatedArtists() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/related-artists");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
    @Test
    public void GetArtistsAlbum() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/albums?include_groups=single%2Cappears_on&market=ES&limit=10&offset=5");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
    @Test
    public void GetSeveralArtist() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/artists?ids=2CIMQHirSU0MQqyYHq0eOx%2C57dN52uHvrHOxijzpIgu3E%2C1vCWHaC5f2uS3yhpwWbIA6");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
}
