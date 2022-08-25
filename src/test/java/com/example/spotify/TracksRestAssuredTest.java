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
    public String token = "Bearer BQCP2-V32MfMr4GTJpAr3LWn_EGEdphRZJbkCmcpNGeoLo9Bm2rfjkRwaa4VxuCa0McyJ8b6lZV1jyvWO6oCwpAt8KnyPj93Kw8j-P-gr0vCNbgTU2XT39d_qCkg3IV2Ar3PwuwXdO5znziSiDnMrCP2SUUpGAu9PmmLmAWnH_5UCvwsjiA_m-0rTOgYet9tRVtP9deU-RwY0S1UNX0okAOX7QQUKOAqv7pA2GcllqpyvV-C-tE190EMRAza3-fe";
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
                .queryParam("11dFghVXANMlKmJXsNCbNl")
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
