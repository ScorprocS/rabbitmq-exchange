package fr.mns.tprabbit.rabbitmq.config;


import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@EnableRabbit
@Configuration
public class RabbitConfiguration {
    @Value("${exchange.name}")
    private String exchangeName;
    
    @Bean
    DirectExchange exchange() {
        return new DirectExchange(exchangeName);
    }
    @Bean
    ObjectMapper objectMapper() {
    	return new ObjectMapper();
    }
    
    /*
    @Bean
    public MessageConverter jackson2MessageConverter() {
      return new Jackson2JsonMessageConverter();
    }
    
    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final var rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jackson2MessageConverter());
        return rabbitTemplate;
    }*/
    
    
}

   
