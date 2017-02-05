package com.pairprogramming.client.view.widget;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class AjaxLoader extends PopupPanel {
	private static AjaxLoader singleton = new AjaxLoader();
	
	private HorizontalPanel loadingPanel;
	private HorizontalPanel writingPanel;
	
	public AjaxLoader(){
		
		setAnimationEnabled(true);
		setSize("500px" ,"80px");
		
		VerticalPanel vPanel = new VerticalPanel();
		vPanel.setSize("100%", "100%");
		
		loadingPanel = new HorizontalPanel();
		loadingPanel.setSize("100%", "100%");
		loadingPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		loadingPanel.setStyleName("loadingPanel");
		loadingPanel.setVisible(false);
		
		Image image = new Image("images/loading.GIF");
		loadingPanel.add(image);
		loadingPanel.setCellHorizontalAlignment(loadingPanel, HasHorizontalAlignment.ALIGN_CENTER);
		
		writingPanel = new HorizontalPanel();
		writingPanel.setSize("100%", "100%");
		writingPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		writingPanel.setStyleName("loadingPanel");
		writingPanel.setVisible(false);
		
		Image image2 = new Image("images/writing.GIF");
		writingPanel.add(image2);
		writingPanel.setCellHorizontalAlignment(writingPanel, HasHorizontalAlignment.ALIGN_CENTER);
		
		vPanel.add(loadingPanel);
		vPanel.add(writingPanel);
		
		add(vPanel);
	}
	
	public void showLoading(){
		setPopupPosition(450,75);
		show();
		loadingPanel.setVisible(true);
	}
	
	public void hideLoading(){
		loadingPanel.setVisible(false);
		hide();
	}
	
	public void showWriting(){
		setPopupPosition(450, 75);
		show();
		writingPanel.setVisible(true);
	}
	
	public void hideWriting(){
		writingPanel.setVisible(false);
		hide();
	}
	
	public static void hideLoadingIcon(){
		AjaxLoader.get().hideLoading();
	}
	
	public static void showLoadingIcon(){
		AjaxLoader.get().showLoading();
	}
	
	public static void hideWritingIcon(){
		AjaxLoader.get().hideWriting();
	}
	
	public static void showWritingIcon(){
		AjaxLoader.get().showWriting();
	}
	
	public static AjaxLoader get(){
		return singleton;
	}
}
