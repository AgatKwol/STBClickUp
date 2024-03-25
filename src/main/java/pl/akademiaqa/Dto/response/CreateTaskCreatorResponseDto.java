package pl.akademiaqa.Dto.response;



//utworzenie z odpowiedzi json obiektu java, ale tylko wybrane pola z otzrymanego obiektu json chce uwzglednic w tym obiekcie java
// zamiane umozliwia dependency jackson.databind, ale chce ono zmianiec mimo wszystko wszystkie pola z jsona na obiekt.
// Zeby zignorowane zostały pozostałe:-->JsonIgnoreProperties
//
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateTaskCreatorResponseDto {

     @JsonProperty("username") // adnotacja wynikajaca z tego ze ustawiam pole obiektu camelCase (bo tak sie robi w java), a rzeczywista odpowiedz json ma inna nazwe. wiec informuje ze zmienilam a bylo tak.
    private String userName;
    private String email;


//    public String getUserName() {
//        return userName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    @Override
//    public String toString() {
//        return "CreateTaskCreatorResponsDto{" +
//                "userName='" + userName + '\'' +
//                ", email='" + email + '\'' +
//                '}';
    }
