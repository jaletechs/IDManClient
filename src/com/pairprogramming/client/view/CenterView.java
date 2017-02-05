package com.pairprogramming.client.view;

import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.ui.MaterialPanel;

import com.google.gwt.user.client.ui.Widget;

public class CenterView extends MaterialPanel{
	private static CenterView singleton = new CenterView();
	
	public CenterView(){
		setTextAlign(TextAlign.LEFT);
		setBackgroundColor("whitesmoke");
		addStyleName("panel");
	}
	
	public void setWidget(Widget widget){
		clear();
		add(widget);
	}
	
	public static CenterView get(){
		return singleton;
	}
}
