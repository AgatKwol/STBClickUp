package pl.akademiaqa.requests.task;

        import io.restassured.response.Response;
        import org.json.JSONObject;
        import pl.akademiaqa.Dto.request.CreateTaskRequestDto;
        import pl.akademiaqa.Dto.request.UpdateTaskRequestDto;
        import pl.akademiaqa.Dto.response.CreateTaskResponseDto;
        import pl.akademiaqa.requests.BaseRequest;
        import pl.akademiaqa.url.ClickUpUrl;

        import static io.restassured.RestAssured.given;

public class UpdateTaskRequest {

    public static Response updateTask(JSONObject updateTask, String taskId) {  //parametr bedzie definiowany w klasie testowej, tutaj tylko info ze ma byc przekazany
        return given()
                .spec(BaseRequest.requestSpecWithLogs())
                .body(updateTask.toString())
                .when()
                .put(ClickUpUrl.getTaskUrl(taskId))
                .then()
                .statusCode(200)
                .log().ifError()
                .extract()
                .response();
        //.as(CreateTaskResponseDto.class); // zamiana responsu który byłby w jsonie na obiekt klasy CreateTaskResponseDto - DESERIALIZACJIA

    }



    public static Response updateTask(UpdateTaskRequestDto taskDto, String taskId) {  //parametr bedzie definiowany w klasie testowej, tutaj tylko info ze ma byc przekazany
        return given()
                .spec(BaseRequest.requestSpecWithLogs())
                .body(taskDto)  // gdy mamy zwykly obiekt nie trzeba wywolywac metody toString
                .when()
                .put(ClickUpUrl.getTaskUrl(taskId))
                .then()
                .statusCode(200)
                .log().ifError()
                .extract()
                .response();
        //.as(CreateTaskResponseDto.class); // zamiana responsu który byłby w jsonie na obiekt klasy CreateTaskResponseDto - DESERIALIZACJIA

    }
}
