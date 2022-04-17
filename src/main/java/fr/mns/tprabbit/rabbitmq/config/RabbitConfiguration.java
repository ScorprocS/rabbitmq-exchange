package fr.mns.tprabbit.rabbitmq.config;


import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author Alex
 *
 */
@EnableRabbit
@Configuration
public class RabbitConfiguration {
	/**
	 * Get the value exchange.name from application.properties
	 */
    @Value("${exchange.name}")
    private String exchangeName;
    
    /**
     * Create if not exists a new direct exchange in rabbitMQ
     * @return
     */
    @Bean
    DirectExchange exchange() {
        return new DirectExchange(exchangeName);
    }
    
    /**
     * Instanciate an ObjectMapper bean to use it everywhere with @Autowired
     * @return
     */
    @Bean
    ObjectMapper objectMapper() {
    	return new ObjectMapper();
    }   
    
}

   
