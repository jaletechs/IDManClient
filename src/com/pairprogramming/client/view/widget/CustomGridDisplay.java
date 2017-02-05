package com.pairprogramming.client.view.widget;

import com.google.gwt.event.dom.client.HasClickHandlers;

public interface CustomGridDisplay<T> {
	HasClickHandlers getAddButton();
	HasClickHandlers getUpdateButton();
	HasClickHandlers getDeleteButton();
	HasClickHandlers getExtraButton();
	CustomDataGrid<T> getGrid();
}
