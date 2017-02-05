package com.pairprogramming.client.view.widget;

import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.ui.MaterialRow;

import com.google.gwt.user.client.ui.Widget;

public class ContentScreen extends MaterialRow{
	private static ContentScreen singleton = new ContentScreen();
	
	public ContentScreen() {
		setTextAlign(TextAlign.LEFT);
		setBackgroundColor("whitesmoke");
		setPaddingLeft(15);
		setPaddingLeft(280);
		setSize("100%", "100%");
		addStyleName("content");
	}
	
	public void addNew(Widget widget){
		MaterialRow row = new MaterialRow();
		row.add(widget);
		add(row);
	}
	
	public void setWidget(Widget widget){
		clear();
		add(widget);
	}
	
	public static ContentScreen get(){
		return singleton;
	}
}
