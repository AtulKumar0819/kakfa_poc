package com.example.kafka.consumer;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.kafka.kafkauser.User;
import com.example.kafka.repository.MessageRepository;

@Component
public class Consumer {
	   private Logger log = LoggerFactory.getLogger(Consumer.class);

   @Autowired
   private MessageRepository messageRepo;
       
       @KafkaListener(topics = "${myapp.kafka.topic}", groupId = "xyz")
       public void consume(ConsumerRecord<String,User> user) {
       log.info("MESSAGE RECEIVED AT CONSUMER END -> " + user);
       //messageRepo.addMessage(user);

}}
