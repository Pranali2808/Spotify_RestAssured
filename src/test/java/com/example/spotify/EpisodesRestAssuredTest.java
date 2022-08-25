package com.example.spotify;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


public class EpisodesRestAssuredTest {
    public String token = "Bearer BQDOn_mkRSNModHPrLeoN7uBJGflFoHVWLbvLsoxCDAij__PsLFrkWi3GSeSrJPHLSKraIBXsHYxtDbFKzcDpMyC191PBFFpel6Gd3xCHBDV_F6d_Lf1GhdnQHv491wjYw4U--m0Zf6XPCW62woe3N9SDIyPUpH30ChGkmjTb3pbkozqgDvGh63sPVT7huIZXQMq8EQYKedbRSTDMYHkzg5_uTYN6zOEae3oHIuIGBbLafXEiptnng";
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
                .get("https://api.spotify.com/v1/episodes?ids=77o6BIVlYM3msb4MMIL1jH&market=ES");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
}
