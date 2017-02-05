package com.pairprogramming.client;

import com.google.gwt.event.shared.SimpleEventBus;

public class EventManager {
	private static SimpleEventBus eventBus = new SimpleEventBus();
	
	private EventManager(){}
	
	public static SimpleEventBus getEventBus(){
		return eventBus;
	}
}
