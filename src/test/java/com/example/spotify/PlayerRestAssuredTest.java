package com.example.spotify;
import io.restassured.RestAssured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


public class PlayerRestAssuredTest {
    public String token = "Bearer BQDOn_mkRSNModHPrLeoN7uBJGflFoHVWLbvLsoxCDAij__PsLFrkWi3GSeSrJPHLSKraIBXsHYxtDbFKzcDpMyC191PBFFpel6Gd3xCHBDV_F6d_Lf1GhdnQHv491wjYw4U--m0Zf6XPCW62woe3N9SDIyPUpH30ChGkmjTb3pbkozqgDvGh63sPVT7huIZXQMq8EQYKedbRSTDMYHkzg5_uTYN6zOEae3oHIuIGBbLafXEiptnng";
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://api.spotify.com/v1/me";
    }
    @Test
    public void GetRecentlyPlayedTracks(){
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
