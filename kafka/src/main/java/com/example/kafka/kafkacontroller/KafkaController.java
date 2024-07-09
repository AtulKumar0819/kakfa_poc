package com.example.kafka.kafkacontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.kafkauser.User;


@RestController
@RequestMapping("/kafka")
public class KafkaController {

//      @Autowired
//      private com.example.kafka.producer.MessageProducer producer;

      @Autowired
      private com.example.kafka.repository.MessageRepository messageRepo;

//      //Send message to kafka
//      @GetMapping("/send")
//      public String sendMsg(
//      @RequestParam("msg") String message) {
//          producer.sendMessage(message);
//          return "" +"'+message +'" + " sent successfully!";
//      }
//
//      //Read all messages
//      @GetMapping("/getAll")
//      public String getAllMessages() {
//         return messageRepo.getAllMessages() ;
//      }
//      
      @Autowired
      private KafkaTemplate<String, User> userKafkaTemplate;

      private static final String TOPIC = "Kafka_Example";

      @GetMapping("/publish/{name}/{id}/{dept}/{salary}")
      public String post(@PathVariable("name") final String name,
    		  @PathVariable("id") final int id,
             @PathVariable("dept") final String dept,
             @PathVariable("salary") final long salary)
      {

    	  userKafkaTemplate.send(TOPIC, new User(id, name, dept, salary));

          return "Published successfully";
      }
}
