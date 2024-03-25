package pl.akademiaqa.Dto.response;



//utworzenie z odpowiedzi json obiektu java, ale tylko wybrane pola z otzrymanego obiektu json chce uwzglednic w tym obiekcie java
// zamiane umozliwia dependency jackson.databind, ale chce ono zmianiec mimo wszystko wszystkie pola z jsona na obiekt.
// Zeby zignorowane zostały pozostałe:-->JsonIgnoreProperties
//
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateTaskStatusResponseDto {

    private  String status;
    private  String type;

//    public String getStatus() {
//        return status;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//
//
//    @Override
//    public String toString() {
//        return "CreateTaskStatusResponseDto{" +
//                "status='" + status + '\'' +
//                ", type='" + type + '\'' +
//                '}';
    }
