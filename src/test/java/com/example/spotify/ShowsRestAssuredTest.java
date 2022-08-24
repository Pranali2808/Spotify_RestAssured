package com.example.spotify;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


public class ShowsRestAssuredTest {
    public String token = "BQAr4MEqTNYhW5wuoQEayR3oV_8L-9UtH5s4qiiLRJjIhnf7gu9W35jBI929lhn_vAuSikSz9-bjBWfK0mGDj6Mupfo8wShQ6rpAx8WRs9AzAHqZH9tbllQS7p52G5LnJufqFkSxrzrLqJu8rIOG0LgXLaa2UCfCmlq_8sWJj9jC3xaS5q3qaB9xFq0SVZUMPf-LfSkSMJD43CmwEHTu9D9xTSDlS3y6RjrStU1DmeRoqpFpuFEPqPN4VGfuxEICoXnGMf1h";
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://api.spotify.com/v1/me";
    }
    @Test
    public void GetShow() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/shows/38bS44xjbVVZ3No3ByF1dJ?market=ES");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void GetShowEpisodes() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/shows/38bS44xjbVVZ3No3ByF1dJ/episodes?market=ES&limit=10&offset=5");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void GetSeveralShows() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/shows?market=ES&ids=5CfCWKI5pZ28U0uOzXkDHe%2C5as3aKmN2k11yfDDDSrvaZ");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
}
