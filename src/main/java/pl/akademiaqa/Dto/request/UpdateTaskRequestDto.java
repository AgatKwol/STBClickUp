package pl.akademiaqa.Dto.request;

import lombok.Data;
@Data //ta adnotacja uzbraja klase w gettery, settery, to strong,
public class UpdateTaskRequestDto {
    private String name;
    private String description;
    private String status;
    private boolean custom_task_ids;



}
