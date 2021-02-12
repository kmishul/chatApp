package com.project.chat_app.service;

import com.project.chat_app.model.ChatBackup;
import com.project.chat_app.repository.ChatBackupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatBackupService {
    @Autowired
    ChatBackupRepository chatBackupRepository;

    public void chatBackUp(String user, String msg_id, String msg) {
        ChatBackup c= new ChatBackup(msg_id,user,msg);
        if(chatBackupRepository!=null)
        chatBackupRepository.save(c);
    }
}
