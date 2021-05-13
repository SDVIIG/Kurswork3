package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.service.RoomService;
import com.example.demo.service.SynchronizationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @PostMapping("/create")
    @ApiOperation("Создание комнаты")
    public RoomIdDto createRoom(@RequestBody RoomCreateDto roomCreateDto) {
        return roomService.createRoom(roomCreateDto);
    }

    @PostMapping("/setTable")
    @ApiOperation("Сделать ход в комнате")
    public void setTable(@RequestBody RoomTableMoveDto roomTableMoveDto) {
        roomService.setTable(roomTableMoveDto);
    }

    @PostMapping("/get")
    @ApiOperation("Получение комнаты")
    public RoomDto getRoom(@RequestBody RoomLoginDto roomLoginDto) {
        return roomService.getRoomDto(roomLoginDto);
    }

    @PostMapping("/send-message")
    @ApiOperation("Отправка сообщения в комнату")
    public void sendMessage(@RequestBody ChatDto chatDto) {
        roomService.sendMessage(chatDto);
    }

    @GetMapping("/get-messages")
    @ApiOperation("Получение чата комнаты")
    public List<RoomMessageDto> getRoomMessages(@ApiParam(value = "Id комнаты", required = true) @RequestParam(name = "roomId")
                                   int roomId) {
        return roomService.getRoomMessages(roomId);
    }

    @GetMapping("/get-nickname")
    @ApiOperation("Получение никнейма")
    public PlayerNicknameDto getNickName(@RequestParam String userId) {
        return roomService.getNickName(userId);
    }
}
