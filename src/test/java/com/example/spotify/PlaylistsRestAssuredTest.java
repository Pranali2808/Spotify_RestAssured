package com.example.spotify;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class PlaylistsRestAssuredTest {

        public String token = "Bearer BQCP2-V32MfMr4GTJpAr3LWn_EGEdphRZJbkCmcpNGeoLo9Bm2rfjkRwaa4VxuCa0McyJ8b6lZV1jyvWO6oCwpAt8KnyPj93Kw8j-P-gr0vCNbgTU2XT39d_qCkg3IV2Ar3PwuwXdO5znziSiDnMrCP2SUUpGAu9PmmLmAWnH_5UCvwsjiA_m-0rTOgYet9tRVtP9deU-RwY0S1UNX0okAOX7QQUKOAqv7pA2GcllqpyvV-C-tE190EMRAza3-fe";
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
        public void AddItemsToPlaylist() {
            Response response = given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("Authorization", token)
                    .queryParam("uris","spotify:track:1301WleyT98MSxVHPZCA6M")
                    .when()
                    .post("https://api.spotify.com/v1/playlists/1ablnFDyvBcM3z9nrHmRKa/tracks?uris=spotify%3Atrack%3A4iV5W9uYEdYUVa79Axb7Rh%2Cspotify%3Atrack%3A1301WleyT98MSxVHPZCA6M");
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


