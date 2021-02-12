package com.project.chat_app.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@Entity
@Table(name = "chat_backup")
public class ChatBackup {
    @Id
    private String msgId;

    private String name;
    private String msg;

    public ChatBackup() {
    }

    public ChatBackup(String msgId, String name, String msg) {
        this.msgId = msgId;
        this.name = name;
        this.msg = msg;
    }
}
