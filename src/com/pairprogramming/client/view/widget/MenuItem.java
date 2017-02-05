package com.pairprogramming.client.view.widget;

import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.constants.IconSize;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialLink;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.pairprogramming.client.dto.PrivilegeDto;
import com.pairprogramming.client.presenter.MenuPresenter;

public class MenuItem extends MaterialLink {
	public MenuItem(final PrivilegeDto dto) {
		super(dto.getDescription());
		setIconType(IconType.CHEVRON_RIGHT);
		setIconSize(IconSize.TINY);
		setIconPosition(IconPosition.LEFT);
		setTextColor("blue");
		addStyleName("link");
		addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				MenuPresenter.doNavigate(dto);
			}
		});
	}
}
