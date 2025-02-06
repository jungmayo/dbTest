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
public class ChatUser {
    private String CUId;
    private String userNo;
    private String roomId;

    public void insertUserAndRoom(String userNo, String roomId) {
        this.CUId = createCuId();
        this.userNo = userNo;
        this.roomId = roomId;
    }

    public String createCuId() {
        String uuid = UUID.randomUUID().toString();
        return "CU" + uuid.substring(0, 8);
    }
}
