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

/**
 * ExchangeSender
 * Used to send json event with header to an exchange
 * @author Alex
 *
 */
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
	
    /**
     * Convert the event to json, add eventType header and send it 
     * @param message
     * @throws JsonProcessingException
     */
    public void sendEvent(Event<?> message) throws JsonProcessingException {
    	//Convert the event to Json
        String messageJson = objectMapper.writeValueAsString(message);
        //MessageProperties allow to add header
	    MessageProperties messageProperties = new MessageProperties(); 
        messageProperties.setHeader("eventType", message.getEventType()); //set the header eventType to the type of the event
        //create the message with json and header
        Message messageObject = new Message(messageJson.getBytes(), messageProperties); //
        //send the message to the exchange with the userEventKey
		rabbitTemplate.convertAndSend(exchange.getName(),userEventKey, messageObject);
	}
	
}
