package pl.akademiaqa.requests.task;

import io.restassured.response.Response;
import org.json.JSONObject;
import pl.akademiaqa.Dto.request.CreateTaskRequestDto;
import pl.akademiaqa.Dto.response.CreateTaskResponseDto;
import pl.akademiaqa.requests.BaseRequest;
import pl.akademiaqa.url.ClickUpUrl;

import static io.restassured.RestAssured.given;

public class CreateTaskRequest {


    // TUTAJ response przyjmuje jako parametr obiek json. Zwracany jest response w formie json
    public static Response createTask(JSONObject task, String listId) {  //parametr bedzie definiowany w klasie testowej, tutaj tylko info ze ma byc przekazany
        return given()
                .spec(BaseRequest.requestSpecWithLogs())
                .body(task.toString())
                .when()
                .post(ClickUpUrl.getTasksUrl(listId))
                .then()
                .log().ifError()
                .extract()
                .response();

    }
// TUTAJ response przyjmuje jako parametr obiek java (CreateTaskRequestDto). Zwracany jest response w formie json
//    public static Response createTask(CreateTaskRequestDto taskDto, String listId) {  //parametr bedzie definiowany w klasie testowej, tutaj tylko info ze ma byc przekazany
//        return given()
//                .spec(BaseRequest.requestSpecWithLogs())
//                .body(taskDto)  // gdy mamy zwykly obiekt nie trzeba wywolywac metody toString
//                .when()
//                .post(ClickUpUrl.getTasksUrl(listId))
//                .then()
//                .log().ifError()
//                .extract()
//                .response();


    // TUTAJ response przyjmuje jako parametr obiek java (CreateTaskRequestDto). Zwracany jest obiekt java
    public static CreateTaskResponseDto createTask(CreateTaskRequestDto taskDto, String listId) {  //parametr bedzie definiowany w klasie testowej, tutaj tylko info ze ma byc przekazany
        return given()
                .spec(BaseRequest.requestSpecWithLogs())
                .body(taskDto)  // gdy mamy zwykly obiekt nie trzeba wywolywac metody toString
                .when()
                .post(ClickUpUrl.getTasksUrl(listId))
                .then()
                .statusCode(200)
                .log().ifError()
                .extract()
                .response()
                .as(CreateTaskResponseDto.class); // zamiana responsu który byłby w jsonie na obiekt klasy CreateTaskResponseDto - DESERIALIZACJIA

    }
}


//.as(CreateTaskResponseDto.class);