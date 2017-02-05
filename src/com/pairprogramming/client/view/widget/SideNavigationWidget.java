package com.pairprogramming.client.view.widget;

import gwt.material.design.addins.client.sideprofile.MaterialSideProfile;
import gwt.material.design.client.constants.Edge;
import gwt.material.design.client.constants.SideNavType;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialSideNav;

import com.pairprogramming.client.cache.CacheManager;

public class SideNavigationWidget extends MaterialSideNav{
	public static SideNavigationWidget instance = new SideNavigationWidget();
	
	public SideNavigationWidget() {
		setId("mysidenav");
		setTop(64);
		setShadow(1);
		setShowOnAttach(true);
		setWidth(280);
		setAlwaysShowActivator(true);
		setType(SideNavType.FIXED);
		setAllowBodyScroll(true);
		setEdge(Edge.LEFT);
		
		MaterialSideProfile profile = new MaterialSideProfile();
		profile.setSeparator(true);
		profile.setUrl("images/bg_top_nav.png");
		MaterialImage image = new MaterialImage("images/d.jpg");
		MaterialLabel label = new MaterialLabel("User");
		label.setTextColor("white");
		profile.add(image);
		profile.add(label);
		
		add(profile);
		add(LeftSideMenu.get());
	}
	
	@Override
	protected void onClosed() {
		ContentScreen.get().setPaddingLeft(15);
		super.onClosed();
	}
	
	@Override
	protected void onOpened() {
		ContentScreen.get().setPaddingLeft(293);
		super.onOpened();
	}
	
	public static SideNavigationWidget get(){
		return instance;
	}
}
