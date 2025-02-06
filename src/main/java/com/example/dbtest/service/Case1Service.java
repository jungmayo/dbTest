package com.example.dbtest.service;

import com.example.dbtest.document.MessageDocument;
import com.example.dbtest.entity.ChatRoom;
import com.example.dbtest.entity.ChatUser;
import com.example.dbtest.mapper.Case1Mapper;
import com.example.dbtest.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class Case1Service {

    private final Case1Mapper case1Mapper;
    private final MessageRepository messageRepository;

    public ResponseEntity<?> case1CreateChatRoom(List<String> userNoList) {

        ChatRoom chatRoom = new ChatRoom();
        chatRoom.createRoomId();

        log.info(chatRoom.toString());

        case1Mapper.insertCase1ChatRoom(chatRoom);

        for (String userNo : userNoList) {
            ChatUser chatUser = new ChatUser();
            chatUser.insertUserAndRoom(userNo, chatRoom.getRoomId());
            case1Mapper.insertCase1ChatUser(chatUser);
        }

        return ResponseEntity.ok().body("Success");
    }

    public ResponseEntity<?> case1CSelectChatRoom(String userNo) {
        List<ChatRoom> chatRoomList = case1Mapper.selectCase1ChatRoom(userNo);

        return ResponseEntity.ok().body(chatRoomList);
    }


    public ResponseEntity<?> case1CreatMsg(MessageDocument messageDocument) {
        messageRepository.save(messageDocument);
        return ResponseEntity.ok().body("Success");

    }

    public ResponseEntity<?> case1FindMsgByUserNoAndChatNo(String roomId) {
        messageRepository.findByMsg(roomId);
        return ResponseEntity.ok().body("Success");

    }

}
