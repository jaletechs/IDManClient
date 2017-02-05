package com.pairprogramming.client.util;

import gwt.material.design.client.ui.MaterialTextArea;
import gwt.material.design.client.ui.MaterialTextBox;

import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;

public class ErrorRemover implements KeyUpHandler{
	@Override
	public void onKeyUp(KeyUpEvent event) {
		if(event.getSource() instanceof MaterialTextBox){
			MaterialTextBox temp = (MaterialTextBox) event.getSource();
			if(!temp.getText().equals("")){
				temp.clearErrorOrSuccess();
			}
		}else if(event.getSource() instanceof MaterialTextArea){
			MaterialTextArea temp = (MaterialTextArea) event.getSource();
			if(!temp.getText().equals("")){
				temp.clearErrorOrSuccess();
			}
		}
	}
}