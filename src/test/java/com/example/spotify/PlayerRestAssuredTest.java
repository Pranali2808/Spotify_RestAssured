package com.example.spotify;
import io.restassured.RestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


public class PlayerRestAssuredTest {
    public String token = "BQAr4MEqTNYhW5wuoQEayR3oV_8L-9UtH5s4qiiLRJjIhnf7gu9W35jBI929lhn_vAuSikSz9-bjBWfK0mGDj6Mupfo8wShQ6rpAx8WRs9AzAHqZH9tbllQS7p52G5LnJufqFkSxrzrLqJu8rIOG0LgXLaa2UCfCmlq_8sWJj9jC3xaS5q3qaB9xFq0SVZUMPf-LfSkSMJD43CmwEHTu9D9xTSDlS3y6RjrStU1DmeRoqpFpuFEPqPN4VGfuxEICoXnGMf1h";
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://api.spotify.com/v1/me";
    }
    @Test
    public void GetRecentlyPlayedTracks() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/me/player/recently-played?limit=10&after=1484811043508");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void GetAvailableDevices() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/me/player/devices");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void GetCurrentlyPlayingTrack() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/me/player/currently-playing?market=ES");
        response.prettyPrint();
        response.then().assertThat().statusCode(204);

    }

}
