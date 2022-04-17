package fr.mns.tprabbit.rabbitmq.event;

public class Event<T extends EventData> {
	private EventType eventType;
	private T data;
	
	public EventType getEventType() {
		return eventType;
	}
	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "Event [eventType=" + eventType + ", data=" + data + "]";
	}
	

}
