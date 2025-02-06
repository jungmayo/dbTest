package com.example.dbtest.controller;

import com.example.dbtest.document.MessageDocument;
import com.example.dbtest.service.Case1Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// 오라클 + 몽고
@Slf4j
@RequiredArgsConstructor
@RestController
public class Case1Controller {

    private final Case1Service case1Service;

    // 채팅방 생성
    @PostMapping("case1/room/insert")
    public ResponseEntity<?> case1ChatInsert(@RequestBody List<String> userNoList) {
        return case1Service.case1CreateChatRoom(userNoList);
    }


    // 채팅방 조회
    @GetMapping("case1/room/select")
    public ResponseEntity<?> case1ChatSelect(@RequestParam("userNo") String userNo) {
        log.info("userNo : " + userNo);
        return case1Service.case1CSelectChatRoom(userNo);
    }


    // 메세지 삽입
    @PostMapping("case1/chat/insert")
    public ResponseEntity<?> case1MsgInsert(@RequestBody MessageDocument messageDocument) {
        return case1Service.case1CreatMsg(messageDocument);

    }

    // 메세지 조회
    @GetMapping("case1/chat/select/{userNo}/{roomId}")
    public ResponseEntity<?> case1MsgSelect(@PathVariable String userNo, @PathVariable String roomId) {
        return case1Service.case1FindMsgByUserNoAndChatNo(roomId);

    }

}
