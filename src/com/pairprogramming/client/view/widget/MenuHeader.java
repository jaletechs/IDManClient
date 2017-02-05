package com.pairprogramming.client.view.widget;

import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.constants.IconSize;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialLink;

public class MenuHeader extends MaterialLink {
	public MenuHeader(String title, MaterialIcon icon) {
		super(title,icon);
		setIconPosition(IconPosition.LEFT);
		setSeparator(true);
		setBackgroundColor("white");
		setTextColor("blue");
		setIconSize(IconSize.LARGE);
		addStyleName("headerme");
	}
}
