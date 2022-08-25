package com.example.spotify;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class BrowseRestAssuredTest {
    public String token = "Bearer BQDOn_mkRSNModHPrLeoN7uBJGflFoHVWLbvLsoxCDAij__PsLFrkWi3GSeSrJPHLSKraIBXsHYxtDbFKzcDpMyC191PBFFpel6Gd3xCHBDV_F6d_Lf1GhdnQHv491wjYw4U--m0Zf6XPCW62woe3N9SDIyPUpH30ChGkmjTb3pbkozqgDvGh63sPVT7huIZXQMq8EQYKedbRSTDMYHkzg5_uTYN6zOEae3oHIuIGBbLafXEiptnng";
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
                .get("https://api.spotify.com/v1/browse/featured-playlists?country=SE&locale=sv_SE&limit=10&offset=5");
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
