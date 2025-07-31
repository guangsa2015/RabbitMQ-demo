package org.example.rabbitmqdemo.consumer;

import com.rabbitmq.client.Channel;
import org.example.rabbitmqdemo.producer.RabbitMQConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 消息消费
 */
@Component
public class RabbitMQConsumer {

    /**
     * 监听队列
     */
    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void handlerMessage(Object message, Message amqMessage, Channel channel){
        try {

            String content = new String(amqMessage.getBody(),"utf-8");
            //String mm=amqMessage.getMessageProperties().getConsumerQueue();
//            if(message instanceof String){
//                System.out.println("啥字符串：");
//            }else if(message instanceof UserMessage){
//                System.out.println("啥对象：");
//            }
            System.out.println("收到消息:"+content);

            //手动确认消息已处理
            channel.basicAck(amqMessage.getMessageProperties().getDeliveryTag(),false);
        } catch (IOException e) {
            //throw new RuntimeException(e);
            System.err.println("消息处理失败：" + e.getMessage());
            // 处理失败时拒绝消息并重回队列（或转发到死信队列）
            //channel.basicNack(amqMessage.getMessageProperties().getDeliveryTag(), false, true);
        }
    }


}
