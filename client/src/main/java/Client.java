import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import dto.RoomDto;
import org.json.JSONObject;

import java.util.List;

public class Client {

    private List<String> servers = List.of("http://localhost:8080", "http://localhost:8090", "http://localhost:8091");

    public String createRoom(String nickName) {
        Unirest.setTimeouts(5000, 5000);
        for (String server : servers) {
            try {
                HttpResponse<String> response = Unirest.post(server + "/room/create")
                        .header("Content-Type", "application/json")
                        .body("{\n  \"nickname\": \"" + nickName + "\",\n  \"userId\": \"" + nickName + "\"\n}")
                        .asString();
                JSONObject jsonObject = new JSONObject(response.getBody());
                return jsonObject.get("roomId").toString();
            } catch (UnirestException e) {
                continue;
            }
        }
        throw new RuntimeException("Сервера недоступны");
    }

    public RoomDto getRoom(String roomId, String nickName) {
        for (String server : servers) {
            try {
                Unirest.setTimeouts(5000, 5000);
                HttpResponse<String> response = Unirest.post(server + "/room/get")
                        .header("Content-Type", "application/json")
                        .body("{\n  \"nickname\": \"" + nickName + "\",\n  \"roomId\":  " + Long.parseLong(roomId) + ",\n  \"userId\": \"" + nickName + "\"\n}")
                        .asString();
                Gson gson = new Gson();
                return gson.fromJson(response.getBody(), RoomDto.class);
            } catch (UnirestException e) {
                continue;
            }
        }
        throw new RuntimeException("Сервера недоступны");
    }

    public void setTable(String roomId, String nickName, int index) {
        for (String server : servers) {
            try {
                Unirest.setTimeouts(5000, 5000);
                Unirest.post(server + "/room/setTable")
                        .header("Content-Type", "application/json")
                        .body("{\n  \"index\": " + index + ",\n  \"roomId\": " + Long.parseLong(roomId) + ",\n  \"userId\": \"" + nickName + "\"\n}")
                        .asString();
                return;
            } catch (UnirestException e) {
                continue;
            }
        }
        throw new RuntimeException("Сервера недоступны");
    }
}
