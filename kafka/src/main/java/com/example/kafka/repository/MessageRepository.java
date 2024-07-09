package com.example.kafka.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.kafka.kafkauser.User;

@Component
public class MessageRepository {
        private List<User> list = new ArrayList<>();
         
    public void addMessage(User user) {
       list.add(user);
    }

    public String getAllMessages() {
       return list.toString();

}
    }