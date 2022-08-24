package com.example.spotify;
import io.restassured.RestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class TracksRestAssuredTest {
    public String token = "BQAr4MEqTNYhW5wuoQEayR3oV_8L-9UtH5s4qiiLRJjIhnf7gu9W35jBI929lhn_vAuSikSz9-bjBWfK0mGDj6Mupfo8wShQ6rpAx8WRs9AzAHqZH9tbllQS7p52G5LnJufqFkSxrzrLqJu8rIOG0LgXLaa2UCfCmlq_8sWJj9jC3xaS5q3qaB9xFq0SVZUMPf-LfSkSMJD43CmwEHTu9D9xTSDlS3y6RjrStU1DmeRoqpFpuFEPqPN4VGfuxEICoXnGMf1h";
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://api.spotify.com/v1/me";
    }
    @Test
    public void GetTrack() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/tracks/11dFghVXANMlKmJXsNCbNl?market=ES");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void GetSeveralTracks() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/audio-features/11dFghVXANMlKmJXsNCbNl");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void GetTracksAudioFeachers() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/audio-features/11dFghVXANMlKmJXsNCbNl");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void GetTracksAudioAnalysis() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/audio-analysis/11dFghVXANMlKmJXsNCbNl");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
}
