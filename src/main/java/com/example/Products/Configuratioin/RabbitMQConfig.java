package com.example.Products.Configuratioin;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue inventoryQueue()
    {
        return new Queue("inventory.queue");
    }

    @Bean
    public DirectExchange inventoryExchange()
    {
        return new DirectExchange("inventory-exchange");
    }

    @Bean
    public Binding inventoryBinding(DirectExchange inventoryExchange,@Qualifier("inventoryQueue")Queue inventoryQueue)
    {
        return BindingBuilder.bind(inventoryQueue).to(inventoryExchange).with("inventory.queue");
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter()
    {
        return new Jackson2JsonMessageConverter();
    }

    public RabbitTemplate template(ConnectionFactory connectionFactory)
    {
        RabbitTemplate template=new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }

}
