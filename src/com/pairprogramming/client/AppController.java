package com.pairprogramming.client;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;
import com.pairprogramming.client.presenter.Presenter;

public class AppController implements Presenter, ValueChangeHandler<String>{
	private final SimpleEventBus eventBus;
	private HasWidgets container;
	
	public AppController(SimpleEventBus eventBus) {
		this.eventBus = eventBus;
		bind();
	}
	
	private void bind(){
		History.addValueChangeHandler(this);
		
//		eventBus.addHandler(ManageManufacturerEvent.TYPE, new ManageManufacturerEventHandler(){
//
//			@Override
//			public void onManageManufacturer(ManageManufacturerEvent event) {
//				History.newItem("manage manufacturers");
//			}
//		});
	}
	
	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		navigate(event);
	}
	
	public void navigate(ValueChangeEvent<String> event){
		String token = event.getValue();
		
		if(token!=null){
			Presenter presenter = null;
			
			//do a lot of weird stuff here
//			if(token.equals("manage manufacturers")){
//				presenter = new ManageManufacturerPresenter(new ManageManufacturerView(), this.eventBus);
//			}else if(token.equals("manage suppliers")){
//				presenter = new ManageSupplierPresenter(new ManageSupplierView(), this.eventBus);
//			}else if(token.equals("manage categories")){
				
			
			if (presenter != null) {
                presenter.go(container);
            }
		}
	}
	

	@Override
	public void go(HasWidgets container) {
		this.container = container;
		if ("".equals(History.getToken())) {
	         History.newItem("main page");
	         
	        } else {
	            History.fireCurrentHistoryState();
	        }
	}
}
