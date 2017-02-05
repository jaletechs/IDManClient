package com.pairprogramming.client.view.widget;

import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialPanel;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.Header;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionModel;
import com.google.gwt.view.client.SingleSelectionModel;

public class CustomGrid<T> extends Composite {

    private DataGrid<T> table;
    private final ListDataProvider<T> dataProvider;
    private SimplePager pager;
    private MaterialContainer vPanel;
    private ListHandler<T> sortHandler;
    private SelectionMode selMode;
    
	public CustomGrid(LinkedHashMap<String, Column> columns, SelectionMode selMode,
			boolean checkBoxSelect, boolean pagination, DataType dataType) {

	    vPanel = new MaterialContainer();
        vPanel.setSize("100%", "100%");
        vPanel.setShadow(1);
	    initWidget(vPanel);
            
	    // Create a CellTable.
	    table = new DataGrid<T>();
	    table.setStyleName("bordered responsive-table");
	    table.setAutoHeaderRefreshDisabled(true);
	    MaterialPanel panel = new MaterialPanel();
	    //panel.addStyleName("emptyImage");
	    panel.setSize("100%", "42vh");
	    MaterialImage empty = new MaterialImage("images/no record.png");
	    empty.setTextAlign(TextAlign.CENTER);
	    empty.addStyleName("emptyImage");
	    //empty.setPaddingLeft(400);
	    //empty.setPaddingTop(50);
	    panel.add(empty);
	    table.setEmptyTableWidget(panel);
	    table.setLoadingIndicator(AjaxLoader.get());
	    table.setPageSize(15);
            
	    SimplePanel tablePanel = new SimplePanel();
	    tablePanel.add(table);
	    vPanel.add(tablePanel);

	    table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

	    //initialize data provider
	    dataProvider = new ListDataProvider<T>(new ArrayList<T>());
	    dataProvider.addDataDisplay(table);
	    
	    //set selection mode
            this.selMode = selMode;
	    setSelectionMode(selMode, checkBoxSelect);
	    
	    //add check box select for table selection
	    if (checkBoxSelect)
	    	addCheckColumn(selMode);

	    //add paging controls
	    if (pagination)
	    	addPagingControls();


            //add sorting
            // Attach a column sort handler to the ListDataProvider to sort the list.
            sortHandler = new ListHandler<T>(
                dataProvider.getList());
            table.addColumnSortHandler(sortHandler);
    
	    //build columns
	    initTableColumns(columns);
    
	    // Set the total row count. This isn't strictly necessary, but it affects
	    // paging calculations, so its good habit to keep the row count up to date.
	    table.setRowCount(dataProvider.getList().size(), true);
	    //table.setRowData(dataProvider.getList());
	    table.setWidth("100%");
	    table.setHeight("50vh");
	    table.setAutoFooterRefreshDisabled(true);
	    
	}

	private void addPagingControls() {
	    SimplePager.Resources pagerResources = GWT.create(
	        SimplePager.Resources.class);
	    pager = new SimplePager(
	        TextLocation.CENTER, pagerResources, false, 0, true);

            // Disallows full data paged grid at all times
            // pager.setRangeLimited(false);


	    // Set the table as the display.
	    pager.setDisplay(table);
	    SimplePanel pagerPanel = new SimplePanel();
	    
	    pagerPanel.addStyleName("panelPager");
	    pagerPanel.add(pager);
	    vPanel.add(pagerPanel);
	}

	public SimplePager getPager() {
		if (pager == null) {
			addPagingControls();
		}
			
		return pager;
	}
	
	private void addCheckColumn(SelectionMode selMode) {
	    // Checkbox column. This table will use a checkbox column for selection.
	    // Alternatively, you can call cellTable.setSelectionEnabled(true) to enable
	    // mouse selection.
	    CheckColumn<T> checkColumn = new CheckColumn<T>() {

		@Override
		public Boolean getValue(T object) {
		    return table.getSelectionModel().isSelected(object);
		}
	    };

            if (selMode == SelectionMode.SINGLE)
                table.addColumn(checkColumn, 
                        SafeHtmlUtils.fromSafeConstant("<br>"));
            else
                table.addColumn(checkColumn, new CheckBoxHeader());
	}

        private class CheckBoxHeader extends Header<Boolean> {
            private boolean value;
            
            public CheckBoxHeader() {
                super(new CheckboxCell());
            }

            @Override
            public Boolean getValue() {
                return value;
            }
            
            /**
            * Handle a browser event that took place within the header.
            * 
            * @param context the context of the header
            * @param elem the parent Element
            * @param event the native browser event
            */
            @Override
            public void onBrowserEvent(Context context, Element elem, 
                    NativeEvent event) {
                
                if ("change".equals(event.getType())) {
                    value = !value;
                    updateRowsSelection(value);
                }
            }

            private void updateRowsSelection(Boolean value) {
                if (value)
                    selectAllRows();
                else
                    removeAllSelection();
            }
        }
        
	private void setSelectionMode(SelectionMode selMode, boolean checkBoxSelect) {
		SelectionModel<T> selModel;
	    if (selMode.equals(SelectionMode.SINGLE))
	    	selModel = new SingleSelectionModel<T>();
	    else
	    	selModel = new MultiSelectionModel<T>();

            if (!checkBoxSelect)
                table.setSelectionModel(selModel);
            else
                table.setSelectionModel(selModel,
                    DefaultSelectionEventManager.<T> createCheckboxManager());
	}

        public void setPageSize(int pageSize) {
            table.setPageSize(pageSize);
        }
        
	private void initTableColumns(LinkedHashMap<String,Column> columns) {
	    for (String columnName: columns.keySet()) {
		table.addColumn(columns.get(columnName),columnName);
	    }
	    redraw();
	}
	
	/**
	 * Clears available data on the grid and renders the given data.
	 * @param data The data to render
	 */
	public void setData(List<T> data) {
		dataProvider.getList().clear();
		dataProvider.getList().addAll(data);
                dataProvider.refresh();
                redraw();
                //remove selection
                removeAllSelection();
	}
	
        private void removeAllSelection() {
	    /*if (selMode.equals(SelectionMode.SINGLE)) {
                SingleSelectionModel<T> selModel =
                        (SingleSelectionModel<T>) table.getSelectionModel();
                
                if (getSelectedObject() != null) {
                    selModel.setSelected(getSelectedObject(), false);
                }
            } else {
		MultiSelectionModel<T> selModel =
			(MultiSelectionModel<T>) table.getSelectionModel();

		Set<T> selectedRows = selModel.getSelectedSet();
                for (T t: selectedRows) {
                    selModel.setSelected(t, false);
                }
            }*/
            
            for (T t: dataProvider.getList()) {
                table.getSelectionModel().setSelected(t, false);
            }
        }
        
        private void selectAllRows() {
            for (T t: dataProvider.getList()) {
                table.getSelectionModel().setSelected(t, true);
            }
        }
        
	/**
	 * Adds the given list of data to the grid
	 * 
	 * @param data the list data to add
	 */
	public void addData(List<T> data) {
		//table.setRowData(0, data);
		dataProvider.getList().addAll(data);
                dataProvider.refresh();
                redraw();
	}
	
	/**
	 * Adds the given data to the list
	 * 
	 * @param data The data to add
	 */
	public void addData(T data) {
		dataProvider.getList().add(data);
                dataProvider.refresh();
                redraw();
	}

	/**
	 * Adds the given data to the list
	 *
	 * @param data The data to add
	 */
	public void addData(T data, int row) {
		dataProvider.getList().add(row, data);
                dataProvider.refresh();
                table.redraw();
	}

        public void updateSelectedData(T data) {
            //int index = dataProvider.getList().
            int index = dataProvider.getList().indexOf(data);
            if (index != -1) //data found in list
                dataProvider.getList().set(index, data);
            else {          //data not found
                removeSelectedRow();
                addData(data);
            }
            dataProvider.refresh();
        }

	public void removeSelectedRow() {
            SingleSelectionModel<T> selModel =
                    (SingleSelectionModel<T>) table.getSelectionModel();

            T selected = selModel.getSelectedObject();
            if (selected != null) {
                dataProvider.getList().remove(selected);
                selModel.setSelected(selected, false);
            }

            dataProvider.refresh();
	}

        public SingleSelectionModel<T> getSingleSelectionModel() {
            SingleSelectionModel<T> selModel =
                    (SingleSelectionModel<T>) table.getSelectionModel();
            
            return selModel;
        }
        
        public MultiSelectionModel<T> getMultiSelectionModel() {
            MultiSelectionModel<T> selModel =
                    (MultiSelectionModel<T>) table.getSelectionModel();
            
            return selModel;
        }
        
	public void removeSelectedRows() {
	    MultiSelectionModel<T> selModel =
		    (MultiSelectionModel<T>) table.getSelectionModel();

	    Set<T> selectedRows = selModel.getSelectedSet();
            dataProvider.getList().removeAll(selectedRows);
            for (T t: selectedRows) {
                selModel.setSelected(t, false);
            }
            
            dataProvider.refresh();
	}

	public void removeAllRows() {
            dataProvider.getList().clear();
            dataProvider.refresh();
            removeAllSelection();
	}

	public T getSelectedObject() {
	    SingleSelectionModel<T> selModel =
		    (SingleSelectionModel<T>) table.getSelectionModel();

	    T selected = selModel.getSelectedObject();

	    return selected;
	}

	public Set<T> getSelectedObjects() {
		MultiSelectionModel<T> selModel =
			(MultiSelectionModel<T>) table.getSelectionModel();

		Set<T> selectedRows = selModel.getSelectedSet();

                return selectedRows;
	}

        public void setSelected(T t, boolean selected) {
            if (t != null) {
                getSingleSelectionModel().setSelected(t, selected);
            }
        }
        
	public HasData<T> getGrid() {
		return table;
	}
	
	public ListDataProvider<T> getDataProvider() {
		return dataProvider;
	}

    public ListHandler<T> getSortHandler() {
        return sortHandler;
    }

    public void redraw() {
        table.redraw();
    }
}
