package com.example.demo.controller;

import com.example.demo.dto.ChatDto;
import com.example.demo.dto.RoomCreateSyncDto;
import com.example.demo.dto.RoomLoginDto;
import com.example.demo.dto.RoomTableMoveDto;
import com.example.demo.service.RoomService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sync")
@RequiredArgsConstructor
public class SyncController {

    private final RoomService roomService;

    @PostMapping("/create")
    @ApiOperation("Создание комнаты")
    public void createRoom(@RequestBody RoomCreateSyncDto createDto) {
        roomService.createRoomSync(createDto);
    }

    @PostMapping("/connect")
    @ApiOperation("Подключение к комнате")
    public void connectRoom(@RequestBody RoomLoginDto roomLoginDto) {
        roomService.loginRoomSync(roomLoginDto);
    }

    @PostMapping("/setTable")
    @ApiOperation("Сделать ход в комнате")
    public void setTable(@RequestBody RoomTableMoveDto roomTableMoveDto) {
        roomService.setTableSync(roomTableMoveDto);
    }

    @PostMapping("/send-message")
    @ApiOperation("Отправка сообщения в комнату")
    public void sendMessage(@RequestBody ChatDto chatDto) {
        roomService.sendMessageSync(chatDto);
    }

    @PostMapping("/get")
    @ApiOperation("Получение комнаты")
    public void getRoom(@RequestBody RoomLoginDto roomLoginDto) {
        roomService.getRoomDtoSync(roomLoginDto);
    }
}
