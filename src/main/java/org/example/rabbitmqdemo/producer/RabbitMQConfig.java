package org.example.rabbitmqdemo.producer;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {
      //队列名称
      public static final String QUEUE_NAME = "hello";
      //交换机名称
      public static final String EXCHANGE_NAME = "hello_exchange";
      //路由键规则（Topic 通配符）
      public static final String ROUTING_KEY_PATTERN = "demo.#";  //* 匹配一个单词，# 匹配多个单词

    /**
     * 创建队列 durable=true 持久化
     * @return
     */
      @Bean("class-type-queue")
      public Queue demoQueue() {
         return QueueBuilder.durable(QUEUE_NAME).withArgument("x-queue-type","classic").build();
      }

     @Bean("class-type-king")
     public Queue demo2Queue() {
         return QueueBuilder.durable(QUEUE_NAME).withArgument("x-queue-type","classic").build();
     }

    /**
     * 创建交换机 durable=true 持久化
     * @return
     */
    @Bean
    public Exchange demoExchange() {
        return ExchangeBuilder.topicExchange(EXCHANGE_NAME).durable(true).build();
    }

    /**
     * 绑定队列与交换机
     * @param queue
     * @param exchange
     * @return
     */
    @Bean
    public Binding demoBinding(@Qualifier("class-type-king") Queue queue, Exchange exchange) {
          return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY_PATTERN).noargs();
    }

    /**
     *  配置 JSON 消息转换器，支持任意对象序列化
     * @return
     */
    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
