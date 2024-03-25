package pl.akademiaqa.requests.folder;

import io.restassured.response.Response;
import org.json.JSONObject;
import pl.akademiaqa.requests.BaseRequest;
import pl.akademiaqa.url.ClickUpUrl;

import static io.restassured.RestAssured.given;

public class CreateFolderRequest {

    public static Response createFolder(JSONObject folder, String spaceId) {  //parametr bedzie definiowany w klasie testowej, tutaj tylko info ze ma byc przekazany
        return given()
                .spec(BaseRequest.requestSpecWithLogs())
                .body(folder.toString())
                .when()
                .post(ClickUpUrl.getFoldersUrl(spaceId))
                .then()
                .log().ifError()
                .extract()
                .response();

    }
}
