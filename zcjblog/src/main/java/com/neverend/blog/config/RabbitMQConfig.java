package com.neverend.blog.config;


import com.neverend.blog.service.mq.MessageReceive;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
@EnableAutoConfiguration
public class RabbitMQConfig {
    public static   String queueName = "Neverend_wei_xin";
    @Value("${spring.rabbitmq.host}")
    public   String HOST;
    @Value("${spring.rabbitmq.username}")
    public   String USERNAME;
    @Value("${spring.rabbitmq.password}")
    public   String PASSWORD;
    @Value("${spring.rabbitmq.port}")
    public   int PORT;

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("Neverend_wei_xin-exchange");
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(queueName);
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(HOST);
        connectionFactory.setPort(PORT);
        connectionFactory.setUsername(USERNAME);
        connectionFactory.setPassword(PASSWORD);
        connectionFactory.setVirtualHost("/");
        //必须要设置,消息的回掉
        connectionFactory.setPublisherConfirms(true);
        return connectionFactory;
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(MessageReceive receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessagesend");
    }


}
