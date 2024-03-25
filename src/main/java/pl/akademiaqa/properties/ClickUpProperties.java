package pl.akademiaqa.properties;

import java.util.ResourceBundle;

public class ClickUpProperties {  // Klasa z metodami zwracajacymi propertisy z pliku .properties

    private static final String TOKEN = "clickup.token";
    private static final String TEAM_ID = "clickup.team.id";


    public static String getToken(){
        return getProperty(TOKEN);
    }

    public static String getTeamId(){
        return getProperty(TEAM_ID);
    }


    private static String getProperty(String key) {
        return ResourceBundle.getBundle("clickup").getString(key);
        //metoda nazwana getProperty ma na celu wywołac dane z pliku properties
        // przy uzyciu tej metody bedzie trzeba podać klucz (String key)- bedzie to nazwa zmiennej danego propertisa utworzona w tej klasie
    }

}
