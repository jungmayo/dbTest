package com.example.dbtest.repository;

import com.example.dbtest.document.MessageDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends MongoRepository<MessageDocument, String> {

    @Query(value = "{'roomId':  ?0 }" , fields = "{'msgId':1,'text': 1, 'type': 1, 'time': 1, 'isRead': 1}")
    List<MessageDocument> findByMsg(String roomId);
}
