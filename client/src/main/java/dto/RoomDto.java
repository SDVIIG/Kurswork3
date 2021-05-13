package dto;

import lombok.Data;

import java.util.List;

@Data
public class RoomDto {
    private int id;
    private RoomStatus status;
    private List<RoomPlayerDto> players;
    private List<Marker> table;
}
