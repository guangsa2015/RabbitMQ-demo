package org.example.rabbitmqdemo;

import jakarta.annotation.Resource;
import org.example.rabbitmqdemo.consumer.UserMessage;
import org.example.rabbitmqdemo.producer.RabbitMQPreduer;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mq")
public class RabbitMQController {

     @Resource
     private RabbitMQPreduer  producer;

     @GetMapping("/{msg}")
     public String sendStringMsg(@PathVariable("msg") String msg){
         producer.sendStringMessage("demo.msg",msg);
         return "success";
     }

     @GetMapping("/obj/{msg}")
     public String sendObjectMsg(@PathVariable("msg") String msg){
          UserMessage userMessage = new UserMessage();
          userMessage.setMsgId("111");
          userMessage.setContent(msg);
          userMessage.setFlag(false);
          producer.sendObjectMessage("demo.obj",userMessage);
          return "success";
     }
}
