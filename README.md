# RabbitMQ-demo


    基于 “交换机（Exchange）- 队列（Queue）” 模型，消息先发送到 Exchange，再通过路由规则（Routing Key + 绑定关系）分发到 Queue。<br/>
    支持多种路由策略（Direct、Topic、Fanout 等），可灵活实现点对点、广播、主题匹配等通信模式。<br/>
    消息在 Queue 中可被多个消费者竞争消费（默认），或通过 Exclusive 队列实现单消费者独占。<br/><br/>


RabbitMQ本地运行demo，实现producer发送消息，consumer监听收消息<br/>
1、spring boot版本3.5.4 , spring-rabbit版本3.26<br/>
2、rabbit server版本4.1.2<br/>
