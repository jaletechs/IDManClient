package com.pairprogramming.client.view.widget;

import gwt.material.design.client.ui.MaterialTitle;

public class ContentHeader extends MaterialTitle {
	
	private static ContentHeader instance = new ContentHeader();
	
	public ContentHeader() {
		setTop(1);
		setSeparator(true);
		setPaddingLeft(15);
	}
	
	public static ContentHeader get(){
		return instance;
	}
}
