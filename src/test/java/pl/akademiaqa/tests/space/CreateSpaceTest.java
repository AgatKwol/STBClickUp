
package pl.akademiaqa.tests.space;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.requests.space.CreateSpaceRequest;
import pl.akademiaqa.requests.space.DeleteSpaceRequest;


class CreateSpaceTest {

    private String spaceId;
    private static final String SPACE_NAME = "JAVA SPACE1";

    @Test

        //STEP1 - CREATE space
    void createSpaceTest() {

        JSONObject space = new JSONObject();
        space.put("name", SPACE_NAME);

        final var response = CreateSpaceRequest.createSpace(space);

        JsonPath json = response.jsonPath();
        spaceId = json.getString("id");

        Assertions.assertThat(response.statusCode()).isEqualTo(200);
        Assertions.assertThat(response.jsonPath().getString("name")).isEqualTo(SPACE_NAME);

        //STEP3 - DELATE space
        final Response deleteResponse = DeleteSpaceRequest.deleteSpace(spaceId);

        Assertions.assertThat(deleteResponse.statusCode()).isEqualTo(200);


    }
}
