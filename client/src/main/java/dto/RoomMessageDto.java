package dto;

import lombok.Data;

import java.util.Date;

@Data
public class RoomMessageDto {
    private String nickname;

    private String message;

    private Date postDate;
}
