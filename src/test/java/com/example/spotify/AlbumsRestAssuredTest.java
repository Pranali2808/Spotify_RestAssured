package com.example.spotify;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class AlbumsRestAssuredTest {
    public String token = "BQCUDz3HfO6AjKy6XeDQy5pS4xhD1IpZ3bM4n9B_SrskK6GTQ65Qyl6GkvWFZzC0wtsK8XuEAbxH6pdlPrrNkaI1EBR1JFlWjhhjpCqRboqU8mYAxOV70yEwY1wXXIJK1-kTLCjldrRIOG1cR0GUIi-IOUT2LtTazcJAZZZm119XyVjT58uhJHB--wFfpVUrVF4vnNRwLiiQ8VUGuaZsDBIsIP4fUsWp2j6rUA_iNdySaQvllrcCZEuELC-D8YWawu9BZdGzsUBEsdmnxsf4NW8xOwY";
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
                .get("https://api.spotify.com/v1/albums?ids=382ObEPsp2rxGrnsizN5TX%2C1A2GTWGtFfWp7KSQTwWOyo%2C2noRn2Aes5aoNVsU6iWThc&market=ES");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
    }
