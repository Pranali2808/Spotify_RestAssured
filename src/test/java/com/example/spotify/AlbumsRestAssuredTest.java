package com.example.spotify;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class AlbumsRestAssuredTest {
    public String token = "Bearer BQDOn_mkRSNModHPrLeoN7uBJGflFoHVWLbvLsoxCDAij__PsLFrkWi3GSeSrJPHLSKraIBXsHYxtDbFKzcDpMyC191PBFFpel6Gd3xCHBDV_F6d_Lf1GhdnQHv491wjYw4U--m0Zf6XPCW62woe3N9SDIyPUpH30ChGkmjTb3pbkozqgDvGh63sPVT7huIZXQMq8EQYKedbRSTDMYHkzg5_uTYN6zOEae3oHIuIGBbLafXEiptnng";
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://api.spotify.com/v1/me";
    }
        @Test
        public void GetAlbum () {
            Response response = given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("Authorization", token)
                    .when()
                    .get("https://api.spotify.com/v1/albums/4aawyAB9vmqN3uQ7FjRGTy?market=ES");
            response.prettyPrint();
            response.then().assertThat().statusCode(200);

        }

        @Test
        public void GetAlbumTracks () {
            Response response = given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("Authorization", token)
                    .when()
                    .get("https://api.spotify.com/v1/albums/4aawyAB9vmqN3uQ7FjRGTy/tracks?market=ES&limit=10&offset=5");
            response.prettyPrint();
            response.then().assertThat().statusCode(200);

        }
    @Test
    public void GetSeveralAlbums() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/albums?ids=382ObEPsp2rxGrnsizN5TX");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
    }
