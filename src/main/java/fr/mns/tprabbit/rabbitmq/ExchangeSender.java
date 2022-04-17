package fr.mns.tprabbit.rabbitmq;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.mns.tprabbit.rabbitmq.event.Event;


@Component
public class ExchangeSender {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private Exchange exchange;
	
	@Autowired
	private ObjectMapper objectMapper;
	  
    @Value("${user.event-key}")
    private String userEventKey;
	
    public void sendEvent(Event<?> message) throws JsonProcessingException {
        String messageJson = objectMapper.writeValueAsString(message);
	    MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader("eventType", message.getEventType());
        Message messageObject = new Message(messageJson.getBytes(), messageProperties);
        
		rabbitTemplate.convertAndSend(exchange.getName(),userEventKey, messageObject);
	}
	
}
