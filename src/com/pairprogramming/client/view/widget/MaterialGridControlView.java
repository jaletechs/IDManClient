package com.pairprogramming.client.view.widget;

import gwt.material.design.client.constants.ButtonType;
import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialPanel;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;

public class MaterialGridControlView<T> extends Composite implements CustomGridDisplay<T> {
	
	private final MaterialButton addButton;
	private final MaterialButton updateButton;
	private final MaterialButton deleteButton;
	private final MaterialButton extraButton;
	
	private CustomDataGrid<T> dataTable;
	private final MaterialPanel contentTable;
	
	public MaterialGridControlView(CustomDataGrid<T> dataTable) {
		this.dataTable = dataTable;
		//a bunch of other stuff
		//DecoratorPanel contentTableDecorator = new DecoratorPanel();
	    //contentTableDecorator.setWidth("100%");
		
		MaterialContainer contentTableDecorator = new MaterialContainer();
	    initWidget(contentTableDecorator);
		
		contentTable = new MaterialPanel();
		
		//create the menu
		HorizontalPanel hPanel = new HorizontalPanel();
		hPanel.setCellHorizontalAlignment(hPanel, HasHorizontalAlignment.ALIGN_LEFT);
		hPanel.setSpacing(0);
		//hPanel.setBorderWidth(0)
		
		addButton = new MaterialButton(ButtonType.RAISED,"Add",new MaterialIcon(IconType.ADD));
		addButton.setIconPosition(IconPosition.LEFT);
		//addButton.setStyleName("saveButton");
		hPanel.add(addButton);
		
		updateButton = new MaterialButton(ButtonType.RAISED,"Update",new MaterialIcon(IconType.UPDATE));
		updateButton.setIconPosition(IconPosition.LEFT);
		//updateButton.setStyleName("saveButton");
		hPanel.add(updateButton);
	
		
		deleteButton = new MaterialButton(ButtonType.RAISED,"Delete",new MaterialIcon(IconType.DELETE));
		deleteButton.setIconPosition(IconPosition.LEFT);
		//deleteButton.setStyleName("saveButton");
		hPanel.add(deleteButton);
		
		extraButton = new MaterialButton(ButtonType.FLOATING,"Extra",new MaterialIcon(IconType.EXIT_TO_APP));
		extraButton.setStyleName("saveButton");
		extraButton.setVisible(false);
		hPanel.add(extraButton);
		
		contentTable.add(hPanel);
		contentTable.add(dataTable);
		
	    contentTableDecorator.add(contentTable);
	}

	@Override
	public HasClickHandlers getAddButton() {
		return addButton;
	}

	@Override
	public HasClickHandlers getUpdateButton() {
		return updateButton;
	}

	@Override
	public HasClickHandlers getDeleteButton() {
		return deleteButton;
	}

	@Override
	public HasClickHandlers getExtraButton() {
		return extraButton;
	}

	@Override
	public CustomDataGrid<T> getGrid() {
		return dataTable;
	}
	
	@Override
	public Widget asWidget(){
		return this;
	}
	
	public void setAddButtonText(String text){
		this.addButton.setText(text);
	}
	
	public void setUpdateButtonText(String text){
		this.updateButton.setText(text);
	}
	
	public void setDeleteButtonText(String text){
		this.deleteButton.setText(text);
	}
	
	public void setExtraButtonText(String text){
		this.extraButton.setText(text);
	}
	
	public void setExtraButtonVisible(){
		extraButton.setVisible(true);
	}
	
	public void hideUpdateButton(){
		this.updateButton.setVisible(false);
	}
	
	public void hideAddButton(){
		this.addButton.setVisible(false);
	}
	
	public void hideDeleteButton(){
		this.deleteButton.setVisible(false);
	}
	
}
