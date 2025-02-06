package com.example.dbtest.mapper;

import com.example.dbtest.entity.ChatRoom;
import com.example.dbtest.entity.ChatUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Case1Mapper {
//@Param("userNO") String userNo
    // 오라클 채팅방 생성
    void insertCase1ChatRoom(ChatRoom chatRoom);
    
    // 오라클 채팅방 멤버 생성
    void insertCase1ChatUser(ChatUser chatUser);

    // 채팅 목록 조회
    List<ChatRoom> selectCase1ChatRoom(String UserNo);

}
