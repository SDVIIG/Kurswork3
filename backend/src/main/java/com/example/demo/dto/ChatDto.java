package com.example.demo.dto;

import lombok.Data;

@Data
public class ChatDto {
    private String userId;
    private long roomId;
    private String message;
}
