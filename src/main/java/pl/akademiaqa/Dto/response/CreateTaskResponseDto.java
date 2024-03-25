package pl.akademiaqa.Dto.response;


//utworzenie z odpowiedzi json obiektu java, ale tylko wybrane pola z otzrymanego obiektu json chce uwzglednic w tym obiekcie java
// zamiane umozliwia dependency jackson.databind, ale chce ono zmianiec mimo wszystko wszystkie pola z jsona na obiekt.
// Zeby zignorowane zostały pozostałe:-->JsonIgnoreProperties
//
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter // pod ta adnotacja kryje sie dostep do getterow
@ToString //pod ta adnotacja kryje sie dostep do metody toString
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateTaskResponseDto {

    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("text_content")
    private String textContent;
    private String description;
    private CreateTaskStatusResponseDto status;
    private CreateTaskCreatorResponseDto creator;




    //ponizsze zastapione dzieki bibliotece Lombok
//    public String getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getTextContent() {
//        return textContent;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public CreateTaskStatusResponseDto getStatus() {
//        return status;
//    }
//
//    public CreateTaskCreatorResponsDto getCreator() {
//        return creator;
//    }
//
//    @Override
//    public String toString() {
//        return "CreateTaskResponseDto{" +
//                "Id='" + Id + '\'' +
//                ", name='" + name + '\'' +
//                ", textContent='" + textContent + '\'' +
//                ", description='" + description + '\'' +
//                ", status=" + status +
//                ", creator=" + creator +
//                '}';
//    }
}
