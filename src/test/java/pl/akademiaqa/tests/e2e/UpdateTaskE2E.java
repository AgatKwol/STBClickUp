package pl.akademiaqa.tests.e2e;

import io.restassured.path.json.JsonPath;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.akademiaqa.Dto.request.CreateTaskRequestDto;
import pl.akademiaqa.Dto.request.UpdateTaskRequestDto;
import pl.akademiaqa.requests.folder.CreateFolderRequest;
import pl.akademiaqa.requests.list.CreateListRequest;
import pl.akademiaqa.requests.space.CreateSpaceRequest;
import pl.akademiaqa.requests.space.DeleteSpaceRequest;
import pl.akademiaqa.requests.task.CreateTaskRequest;
import pl.akademiaqa.requests.task.UpdateTaskRequest;

class UpdateTaskE2E {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateTaskE2E.class);
    private static String spaceName = "tablica do testu E2E";
    private static String listName = "lista do testu E2E";
    private static String taskName = "task do testu E2E";
    private static String taskDescription = "description e2e";
    private static String taskStatus = "to do";
    private static String taskType = "open";
    private static String folderName = "folder e2e";
    private String spaceId;
    private String listId;
    private String taskId;
    private String folderId;

    @Test
    void UpdateTaskE2ETest() {
        spaceId = createSpaceStep();
        LOGGER.info("Space created with Id: {}", spaceId);

//        folderId = createFolderStep();
//        LOGGER.info("Fodler created with id: {}", folderId);

        listId = createListStep();
        LOGGER.info("List created with Id: {}", listId);

        taskId = createTaskStep();
        LOGGER.info("Task created with Id: {}", taskId);

        updateTaskStep();
        closeTaskStep();
        deleteSpaceStep();
    }
    //metoda testowa zawiera kroki: 1 step - utworzenie space -> 2 step - utorzenie listy -> 3 step - dodanie taska -> 4 step - zmiana taska  -> 5 step - usniecie space

    //1
    private String createSpaceStep() { // metoda nie jest void (jest String zamiast void, to znaczy ze metoda moze cos zwracac)

        JSONObject space = new JSONObject();
        space.put("name", spaceName);
        final var response = CreateSpaceRequest.createSpace(space);

        Assertions.assertThat(response.statusCode()).isEqualTo(200);

        JsonPath jsonData = response.jsonPath();
        Assertions.assertThat(jsonData.getString("name")).isEqualTo(spaceName);
        return jsonData.getString("id");
    }

    private String createFolderStep() {
        JSONObject folder = new JSONObject();
        folder.put("name", folderName);
        final var response = CreateFolderRequest.createFolder(folder, spaceId);

        Assertions.assertThat(response.statusCode()).isEqualTo(200);

        JsonPath jsonData = response.jsonPath();
        Assertions.assertThat(jsonData.getString("name")).isEqualTo(folderName);
        return jsonData.getString("id");

    }

    //2
    private String createListStep() {

        JSONObject list = new JSONObject();
        list.put("name", listName);

        final var response = CreateListRequest.createList(list, spaceId);

        Assertions.assertThat(response.statusCode()).isEqualTo(200);

        JsonPath jsonData = response.jsonPath();
        Assertions.assertThat(jsonData.getString("name")).isEqualTo(listName);

        return jsonData.getString("id");  //id listy

    }


    private String createTaskStep() {

        // JSONObject task = new JSONObject();
//        task.put("name", taskName);
//        task.put("description", taskDescription);
//        task.put("status", taskStatus);
//        task.put("custom_task_ids", "true");

        // SERJALIZACJA - zwykly java obiket (pojo) zostaje zamieniony na jsona.
        CreateTaskRequestDto taskDto = new CreateTaskRequestDto();
        taskDto.setName(taskName);
        taskDto.setDescription(taskDescription);
        taskDto.setStatus("to do");

        final var response = CreateTaskRequest.createTask(taskDto, listId);
        LOGGER.info("CREATE TASK RESPONSE OBJ: {}", response);


        //zanim wprowadzilam Dto bylo:
//        Assertions.assertThat(response.statusCode()).isEqualTo(200);
//
//        JsonPath jsonData = response.jsonPath();
//        Assertions.assertThat(jsonData.getString("name")).isEqualTo(taskName);
//        Assertions.assertThat(jsonData.getString("description")).isEqualTo(taskDescription);
//
        // return jsonData.getString("id");


        Assertions.assertThat(response.getName()).isEqualTo(taskName);
        Assertions.assertThat(response.getDescription()).isEqualTo(taskDescription);
        //Assertions.assertThat(response.getStatus()).isEqualTo("to do");

        return response.getId();


    }

    //4

    private void updateTaskStep() {

        //jak do updejtu PUT uzywam obiektu java (pojo) to problemem jest ze pola inne niz updejtowane ustawione są na domyslnie lub null. Lepiej uzywac obiektu json
//        UpdateTaskRequestDto taskDto = new UpdateTaskRequestDto();
//        taskDto.setName("zmienina nazwa tasku");
//        taskDto.setDescription("zmienina nazwa opisu");


        JSONObject updateTask = new JSONObject();
        updateTask.put("name", "zmienina nazwa tasku");
        updateTask.put("description", "zmienina nazwa opisu");


        //UpdateTaskRequest.updateTask(updateTask,taskId);

        final var response = UpdateTaskRequest.updateTask(updateTask, taskId);
        Assertions.assertThat(response.statusCode()).isEqualTo(200);

        JsonPath jsonData = response.jsonPath();
        Assertions.assertThat(jsonData.getString("name")).isEqualTo("zmienina nazwa tasku");
        Assertions.assertThat(jsonData.getString("description")).isEqualTo("zmienina nazwa opisu");

    }
    // 5

    private void closeTaskStep() {
        JSONObject closeTask = new JSONObject();
        closeTask.put("status", "complete");

        final var response = UpdateTaskRequest.updateTask(closeTask, taskId);
        Assertions.assertThat(response.statusCode()).isEqualTo(200);

        JsonPath jsonData = response.jsonPath();
        Assertions.assertThat(jsonData.getString("status.status")).isEqualTo("complete"); //status.status bo uderzamy do pola status w obiekcie status
    }

    private void deleteSpaceStep() {
        final var response = DeleteSpaceRequest.deleteSpace(spaceId);
        Assertions.assertThat(response.statusCode()).isEqualTo(200);


    }

}
