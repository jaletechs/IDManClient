package com.pairprogramming.client.view;

import com.google.gwt.user.client.ui.VerticalPanel;

public class RightSideView extends VerticalPanel {
	private static RightSideView singleton = new RightSideView();
	
	public RightSideView(){
		setSize("100%","100%");
		setStyleName("rightSideView");
		setSpacing(1);
		//setBorderWidth(1);
	}//end constructor
	
	public static RightSideView get(){
		return singleton;
	}
}
