package org.example.rabbitmqdemo.producer;

import org.example.rabbitmqdemo.consumer.UserMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQPreduer {
      private final RabbitTemplate rabbitTemplate;
      public RabbitMQPreduer(RabbitTemplate template) {
            this.rabbitTemplate=template;
      }

      /**
       * 发送消息
       * @param routingKey
       * @param message
       */
      public void sendStringMessage(String  routingKey,String message) {
            rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, routingKey,message);
            System.out.println("Sent string message ["+message+"] to "+routingKey);
      }

      /**
       * 发送对象消息
       * @param routingKey
       * @param message
       */
      public void sendObjectMessage(String routingKey, UserMessage message) {
            rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME,routingKey,message);
            System.out.println("Sent object message ["+message+"] to "+routingKey);

      }
}
