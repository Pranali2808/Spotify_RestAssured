package com.example.spotify;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class MarketsRestAssuredTest {
    public String token = "Bearer BQCP2-V32MfMr4GTJpAr3LWn_EGEdphRZJbkCmcpNGeoLo9Bm2rfjkRwaa4VxuCa0McyJ8b6lZV1jyvWO6oCwpAt8KnyPj93Kw8j-P-gr0vCNbgTU2XT39d_qCkg3IV2Ar3PwuwXdO5znziSiDnMrCP2SUUpGAu9PmmLmAWnH_5UCvwsjiA_m-0rTOgYet9tRVtP9deU-RwY0S1UNX0okAOX7QQUKOAqv7pA2GcllqpyvV-C-tE190EMRAza3-fe";
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://api.spotify.com/v1/me";
    }
    @Test
    public void GetAvailableMarkets() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/markets");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
}
