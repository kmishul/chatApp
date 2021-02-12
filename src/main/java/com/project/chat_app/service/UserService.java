package com.project.chat_app.service;

import com.project.chat_app.model.User;
import com.project.chat_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.sql.Date;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void addUserInDB(String user) {
    User u=new User(user,new Date(System.currentTimeMillis()));
    //if(userRepository!=null)
    userRepository.save(u);
    }

}
