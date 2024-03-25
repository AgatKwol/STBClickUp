package pl.akademiaqa.Dto.request;


import lombok.Data;

@Data //ta adnotacja uzbraja klase w gettery, settery, to strong,
public class CreateTaskRequestDto {
    private String name;
    private String description;
    private String status;
    private boolean custom_task_ids;

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public boolean isCustom_task_ids() {
//        return custom_task_ids;
//    }
//
//    public void setCustom_task_ids(boolean custom_task_ids) {
//        this.custom_task_ids = custom_task_ids;
//    }
//
//    @Override
//    public String toString() {
//        return "CreateTaskRequestDto{" +
//                "name='" + name + '\'' +
//                ", description='" + description + '\'' +
//                ", status='" + status + '\'' +
//                ", custom_task_ids=" + custom_task_ids +
//                '}';
//    }
}
