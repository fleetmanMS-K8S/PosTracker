package com.example.demo;


import org.json.JSONObject;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@Component
public class Positionlistener {

    @Autowired
	private Dataprocessing dataservice;
	
	@RabbitListener(queues = "Fleetman")
	public void onMessage(Message  message) {
		JSONObject obj = new JSONObject(new String(message.getBody()));
		System.out.println("Consuming Message - " + new String(message.getBody()));
		dataservice.updateposition(new String(message.getBody()));

	}

}
