package com.project.chat_app.repository;

import com.project.chat_app.model.ChatBackup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatBackupRepository extends JpaRepository<ChatBackup,String> {
}
