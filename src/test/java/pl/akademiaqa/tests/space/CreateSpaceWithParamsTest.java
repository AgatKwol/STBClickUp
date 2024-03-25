package pl.akademiaqa.tests.space;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.akademiaqa.requests.space.CreateSpaceRequest;
import pl.akademiaqa.requests.space.DeleteSpaceRequest;

import java.util.stream.Stream;

class CreateSpaceWithParamsTest {


    private String spaceId;   

    @ParameterizedTest
    @DisplayName(value = "Create Space with valid name: {0}")
    @MethodSource("sampleSpaceNameData")
        //informacja jak sie nazwym metoda z ktorej argumenty maja byc przekazane jako parametry do testu
        //STEP1 - CREATE space
        //Konwencja nazewnictwa w javie. Jeżeli zmienna jest stała (nie będzie się nigdy zmieniała) public static final String SPACE_NAME – to nazwę stałej piszemy wielkimi literami.//Jeżeli jest to zwykła zmienna np private static String spaceName – to nazwę takiej zmiennej piszemy camel case.
    void createSpaceTest(String spaceName) {

        //create spaces

        JSONObject space = new JSONObject();
        space.put("name", spaceName);

        final var response = CreateSpaceRequest.createSpace(space);

        JsonPath json = response.jsonPath();
        spaceId = json.getString("id");

        Assertions.assertThat(response.statusCode()).isEqualTo(200);
        Assertions.assertThat(response.jsonPath().getString("name")).isEqualTo(spaceName);

        final Response deleteResponse = DeleteSpaceRequest.deleteSpace(spaceId);
        Assertions.assertThat(deleteResponse.statusCode()).isEqualTo(200);

    }

    private static Stream<Arguments> sampleSpaceNameData() {
        return Stream.of(
                Arguments.of("Space1"),
                Arguments.of("@"),
                Arguments.of("."),
                Arguments.of(" "),
                Arguments.of("0")
        );
    }


}
