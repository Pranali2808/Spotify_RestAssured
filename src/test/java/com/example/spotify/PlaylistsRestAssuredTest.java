package com.example.spotify;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class PlaylistsRestAssuredTest {

        public String token = "BQCUDz3HfO6AjKy6XeDQy5pS4xhD1IpZ3bM4n9B_SrskK6GTQ65Qyl6GkvWFZzC0wtsK8XuEAbxH6pdlPrrNkaI1EBR1JFlWjhhjpCqRboqU8mYAxOV70yEwY1wXXIJK1-kTLCjldrRIOG1cR0GUIi-IOUT2LtTazcJAZZZm119XyVjT58uhJHB--wFfpVUrVF4vnNRwLiiQ8VUGuaZsDBIsIP4fUsWp2j6rUA_iNdySaQvllrcCZEuELC-D8YWawu9BZdGzsUBEsdmnxsf4NW8xOwY";
        public String userId = "31bwppxqj44ijzqpuvt3e7ulrq64";
        @BeforeAll
        public static void setup() {
            RestAssured.baseURI = "https://api.spotify.com/v1/me";
        }
        @Test(priority = 1)
        public void createPlaylist() {
            Response response = given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("Authorization", token)
                    .body("{\n" +
                            "  \"name\": \"Bollywood Songs\",\n" +
                            "  \"description\": \"create new playlist \",\n" +
                            "  \"public\": false\n" +
                            "}")
                    .when()
                    .post("https://api.spotify.com/v1/users/31bwppxqj44ijzqpuvt3e7ulrq64/playlists");
            response.prettyPrint();
            Assertions.assertEquals(201, response.statusCode());
        }
        @Test(priority = 2)
        public void addItemsToPlaylist() {
            Response response = given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("Authorization", token)
                    .when()
                    .post("https://api.spotify.com/v1/playlists/10XKiQHi9vjNU39PHfeTxg/tracks?position=0&uris=spotify%3Atrack%3A4iV5W9uYEdYUVa79Axb7Rh%2Cspotify%3Atrack%3A1301WleyT98MSxVHPZCA6M");
            response.prettyPrint();
            response.then().assertThat().statusCode(201);

        }

        @Test(priority = 3)
        public void GetUsersPlaylists() {
            Response response = given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("Authorization", token)
                    .when()
                    .get("https://api.spotify.com/v1/users/31bwppxqj44ijzqpuvt3e7ulrq64/playlists?offset=5&limit=10");
            response.prettyPrint();
            response.then().assertThat().statusCode(200);

        }

        @Test(priority = 4)
        public void GetPlaylistItems() {
            Response response = given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("Authorization", token)
                    .when()
                    .get("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/tracks?market=ES&fields=items(added_by.id%2Ctrack(name%2Chref%2Calbum(name%2Chref)))&limit=10&offset=5");
            response.prettyPrint();
            response.then().assertThat().statusCode(200);

        }

        @Test(priority = 5)
        public void ChangePlaylistDetails() {
            Response response = given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("Authorization", token)
                    .body("{\n" +
                            "    \"name\": \"All time Hit songs\",\n" +
                            "    \"description\": \"Updated playlist description\",\n" +
                            "    \"public\": false\n" +
                            "}")
                    .when()
                    .put("https://api.spotify.com/v1/playlists/10XKiQHi9vjNU39PHfeTxg");
            response.prettyPrint();
            Assertions.assertEquals(200, response.statusCode());
        }
    }


