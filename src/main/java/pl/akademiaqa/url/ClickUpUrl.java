package pl.akademiaqa.url;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClickUpUrl {
    // jest to stała prywatna datego zeby moc z niej korzystac w innych klasach, trzeba utowrzyc publiczna metode zwracajaca te stałą.
    private static final String BASE_URL = "https://api.clickup.com/api/v2";//
    private static final String TEAM = "/team";
    private static final String SPACE = "/space";
    private static final String LIST = "/list";
    private static final String TASK = "/task";
    private static final String FOLDER = "/folder";

    // https://api.clickup.com/api/v2
    public static String getBaseUrl() {

        return BASE_URL;
    }

    //BASE_URL/team
    //public static String getTeamsUrl() {return BASE_URL + TEAM;}  - zanim powstała klasa BaseRequest
    public static String getTeamsUrl() {
        return TEAM;
    }
    //BASE_URL/team/<1234567>
    //public static String getTeamUrl(String teamId) {return BASE_URL + TEAM + "/" + teamId;}  - zanim powstała klasa BaseRequest
    public static String getTeamUrl(String teamId) {
        return TEAM + "/" + teamId;
    }

    //getTeamUrl/space   --> czyli ---> BASE_URL/team/<1234567>/space
    public static String getSpacesUrl(String teamId) {
        return getTeamUrl(teamId) + SPACE;
    }

    //getTeamUrl/space   --> czyli ---> BASE_URL/team/<1234567>/space - do usuwania space (nie trzeba podawac teamId wystarczy spaceID)
    public static String getSpaceUrl(String spaceId) {
        return SPACE + "/" + spaceId;
    }

    //zwraca url list
    public static String getListsUrl(String spaceId){
        return getSpaceUrl(spaceId) + LIST;
    }

    //  - /list/{{list_id}}
    public static String getListUrl(String listId){
        return LIST + "/" + listId;
    }
    //  - /list/{{list_id}}/task
    public static String getTasksUrl(String listId){
        return getListUrl(listId) + TASK;
    }
    public static String getTaskUrl(String taskId){
        return TASK + "/" + taskId;

    }

    ///space/{space_id}/folder
    public static String getFoldersUrl(String spaceId){
        return getSpaceUrl(spaceId) + FOLDER;
    }

    //folder/{folder_id}

    public static String getFolderUrl(String folderId){
        return FOLDER + "/" + folderId;
    }



}