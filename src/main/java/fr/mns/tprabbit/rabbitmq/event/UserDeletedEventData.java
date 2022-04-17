package fr.mns.tprabbit.rabbitmq.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDeletedEventData extends EventData{
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "UserDeletedEventData [id=" + id + "]";
	}
	
	

}
