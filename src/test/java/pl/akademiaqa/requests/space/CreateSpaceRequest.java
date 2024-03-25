
package pl.akademiaqa.requests.space;

import io.restassured.response.Response;
import org.json.JSONObject;
import pl.akademiaqa.properties.ClickUpProperties;
import pl.akademiaqa.requests.BaseRequest;
import pl.akademiaqa.url.ClickUpUrl;

import static io.restassured.RestAssured.given;

public class  CreateSpaceRequest {


    public static Response createSpace(JSONObject space){  //parametr bedzie definiowany w klasie testowej, tutaj tylko info ze ma byc przekazany
    return given()
            .spec(BaseRequest.requestSpecWithLogs())
            .body(space.toString())
            .when()
            .post(ClickUpUrl.getSpacesUrl(ClickUpProperties.getTeamId()))
            .then()
            .log().ifError()
            .extract()
            .response();

    }


}
