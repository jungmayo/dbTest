package com.example.dbtest.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ChatRoom {
    private String roomId;
    private String roomStatus;

    public void createRoomId() {
        String uuid = UUID.randomUUID().toString();
        this.roomId = "CR" + uuid.substring(0, 8);
    }
}
