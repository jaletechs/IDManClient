package com.pairprogramming.client.presenter;

import com.google.gwt.event.shared.SimpleEventBus;
import com.pairprogramming.client.EventManager;
import com.pairprogramming.client.dto.PrivilegeDto;

public class MenuPresenter {
	private static SimpleEventBus eventBus = EventManager.getEventBus();
	
	public static void doNavigate(PrivilegeDto privilege) {
		if(privilege.getDescription().equals("Manage ID Generation")){
			//eventBus.fireEvent(new ManageManufacturerEvent());
		}
	}
}
