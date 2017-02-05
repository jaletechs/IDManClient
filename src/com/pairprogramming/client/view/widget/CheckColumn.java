package com.pairprogramming.client.view.widget;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.user.cellview.client.Column;

public abstract class CheckColumn<T> extends Column<T, Boolean> {

	 /**
	   * Construct a new CheckBoxColumn.
	   */
	  public CheckColumn(boolean isSelected) { 
		  super(new CheckboxCell(isSelected));
	  }
	  
	  public CheckColumn() {
		  this(false);
	  }
	
}
