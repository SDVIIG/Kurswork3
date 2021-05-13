package com.example.demo.dto;

import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class RoomMessageDto {
    private String nickname;

    private String message;

    @Temporal(TemporalType.TIMESTAMP)
    private Date postDate;
}
