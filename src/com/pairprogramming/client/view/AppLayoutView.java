package com.pairprogramming.client.view;

import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.ui.MaterialColumn;
import gwt.material.design.client.ui.MaterialFooter;
import gwt.material.design.client.ui.MaterialFooterCopyright;
import gwt.material.design.client.ui.MaterialHeader;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialNavBar;
import gwt.material.design.client.ui.MaterialNavBrand;
import gwt.material.design.client.ui.MaterialNavSection;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialRow;
import gwt.material.design.client.ui.MaterialSideNav;

import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.pairprogramming.client.view.widget.ContentHeader;
import com.pairprogramming.client.view.widget.ContentScreen;
import com.pairprogramming.client.view.widget.LogoutWidget;
import com.pairprogramming.client.view.widget.SideNavigationWidget;

public class AppLayoutView extends Composite{
	private static final AppLayoutView singleton = new AppLayoutView();
	private AppLayoutView(){
		MaterialPanel panel = new MaterialPanel();
		panel.addStyleName("panel");
		panel.setShadow(1);
		initWidget(panel);
		
		//the side nav
		
		MaterialSideNav sideNav = SideNavigationWidget.get();
		
		//App Header
		MaterialHeader header = new MaterialHeader();
		MaterialNavBrand brand = new MaterialNavBrand();
		brand.setText("ID Card Manager");
		brand.setPaddingLeft(20);
		brand.setFontSize("25px");
		
		MaterialNavSection section = LogoutWidget.get();
		
		MaterialNavBar bar = new MaterialNavBar();
		bar.setBackgroundColor("blue");
		
		bar.add(brand);
		bar.add(section);
		bar.setActivates("mysidenav");
		
		header.add(bar);
		header.add(sideNav);
		
		
		ContentScreen screen = ContentScreen.get();
		screen.addNew(ContentHeader.get());
		screen.addNew(CenterView.get());
		
		MaterialFooter footer = new MaterialFooter();
		footer.addStyleName("footer");
		//footer.setBackgroundColor("blue");
		MaterialRow row = new MaterialRow();
		MaterialColumn column = new MaterialColumn();
		row.add(column);
		MaterialFooterCopyright copyright = new MaterialFooterCopyright();
		copyright.addStyleName("footer-copyright");
		copyright.setFloat(Float.LEFT);
		MaterialLabel text = new MaterialLabel("© 2016 Copyright JALETECHS");
		text.setTextAlign(TextAlign.LEFT);
		copyright.add(text);
		column.add(copyright);
		footer.add(row);
		
		//screen.addNew(footer);
		
		ScrollPanel screenRow = new ScrollPanel();
		screenRow.setSize("100%", "100%");
		screenRow.setStyleName("contentScroller");
		screenRow.add(screen);
		
		panel.add(header);
		panel.add(screenRow);
	}
	
	public static AppLayoutView get(){
		return singleton;
	}
}