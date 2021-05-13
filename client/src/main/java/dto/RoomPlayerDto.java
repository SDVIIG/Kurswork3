package dto;

import lombok.Data;

@Data
public class RoomPlayerDto {
    private String id;
    private Marker marker;
    private boolean win;
    private boolean move;
    private String nickname;
}
