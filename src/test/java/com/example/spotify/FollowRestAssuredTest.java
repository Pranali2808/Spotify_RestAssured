package com.example.spotify;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


public class FollowRestAssuredTest {
    public String token = "BQAr4MEqTNYhW5wuoQEayR3oV_8L-9UtH5s4qiiLRJjIhnf7gu9W35jBI929lhn_vAuSikSz9-bjBWfK0mGDj6Mupfo8wShQ6rpAx8WRs9AzAHqZH9tbllQS7p52G5LnJufqFkSxrzrLqJu8rIOG0LgXLaa2UCfCmlq_8sWJj9jC3xaS5q3qaB9xFq0SVZUMPf-LfSkSMJD43CmwEHTu9D9xTSDlS3y6RjrStU1DmeRoqpFpuFEPqPN4VGfuxEICoXnGMf1h";
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://api.spotify.com/v1/me";
    }
    @Test
    public void FollowPlaylist() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .put("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/followers");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
    @Test
    public void FollowArtistsOrUsers() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .put("https://api.spotify.com/v1/me/following?type=artist&ids=2CIMQHirSU0MQqyYHq0eOx%2C57dN52uHvrHOxijzpIgu3E%2C1vCWHaC5f2uS3yhpwWbIA6");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
    @Test
    public void GetFollowedArtists() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/me/following?type=artist&after=0I2XqVXqHScXjHhk6AYYRe&limit=10");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void CheckIfUsersFollowPlaylist() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/followers/contains?ids=jmperezperez%2Cthelinmichael%2Cwizzler");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void CheckIfUserFollowsArtistsOrUsers() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/me/following/contains?type=artist&ids=2CIMQHirSU0MQqyYHq0eOx%2C57dN52uHvrHOxijzpIgu3E%2C1vCWHaC5f2uS3yhpwWbIA6");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void UnfollowArtistsOrUsers() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .delete("https://api.spotify.com/v1/me/following?type=artist&ids=2CIMQHirSU0MQqyYHq0eOx%2C57dN52uHvrHOxijzpIgu3E%2C1vCWHaC5f2uS3yhpwWbIA6");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void UnfollowPlaylist() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .delete("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/followers");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
}
