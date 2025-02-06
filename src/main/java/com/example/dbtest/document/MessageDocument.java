package com.example.dbtest.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "chat")
public class MessageDocument {

    @Id
    private String msgId;

    private String roomId;
    private String userNo;
    private String text;
    private String type;
    private LocalDateTime time;
    private boolean isRead;

}
