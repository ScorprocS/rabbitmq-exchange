package fr.mns.tprabbit.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;

import fr.mns.tprabbit.rabbitmq.ExchangeSender;
import fr.mns.tprabbit.rabbitmq.event.Event;
import fr.mns.tprabbit.rabbitmq.event.EventType;
import fr.mns.tprabbit.rabbitmq.event.UserDeletedEventData;
import fr.mns.tprabbit.rabbitmq.event.UserEventData;

@Controller
public class HomeController {
	@Autowired
	private ExchangeSender exchangeSender;
	
	@GetMapping("created")
	public ResponseEntity<String> created() {
		 
		Event<UserEventData> event=new Event<UserEventData>();
		event.setEventType(EventType.USER_CREATED);
		UserEventData data= new UserEventData();
		data.setId(1l);
		data.setUserName("test");
		data.setEmail("test@test.fr");
		data.setFirstName("Alex");
		data.setLastName("Test");
		
		event.setData(data);
		
		try {
			exchangeSender.sendEvent( event);
		} catch (JsonProcessingException e) {
			return ResponseEntity.internalServerError().build();
		}
		
		return ResponseEntity.ok("send");
	}
	@GetMapping("updated")
	public ResponseEntity<String> updated() {
		 
		Event<UserEventData> event=new Event<UserEventData>();
		event.setEventType(EventType.USER_UPDATED);
		UserEventData data= new UserEventData();
		data.setId(1l);
		data.setUserName("test123");
		data.setEmail("test123@test.fr");
		data.setFirstName("Alexandre");
		data.setLastName("Test123");
		
		event.setData(data);
		
		try {
			exchangeSender.sendEvent( event);
		} catch (JsonProcessingException e) {
			return ResponseEntity.internalServerError().build();
		}
		
		return ResponseEntity.ok("send");
	}
	
	@GetMapping("deleted")
	public ResponseEntity<String> deleted() {
		 
		Event<UserDeletedEventData> event=new Event<UserDeletedEventData>();
		event.setEventType(EventType.USER_DELETED);
		UserDeletedEventData data= new UserDeletedEventData();
		data.setId(1l);
		
		event.setData(data);
		
		try {
			exchangeSender.sendEvent( event);
		} catch (JsonProcessingException e) {
			return ResponseEntity.internalServerError().build();
		}
		
		return ResponseEntity.ok("send");
	}
}
