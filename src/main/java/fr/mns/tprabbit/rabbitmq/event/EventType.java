package fr.mns.tprabbit.rabbitmq.event;

/**
 * Determine the eventType
 * Used to know how to deserialised the data in the consumer and what to do with it
 * @author Alex
 *
 */
public enum EventType {
	USER_CREATED,USER_UPDATED,USER_DELETED;

}
