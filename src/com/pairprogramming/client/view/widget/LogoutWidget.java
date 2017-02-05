/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pairprogramming.client.view.widget;

import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialNavSection;

import com.google.gwt.dom.client.Style.Float;

/**
 *
 * @author JALETECHS
 */
public class LogoutWidget extends MaterialNavSection {
   public static LogoutWidget instance = new LogoutWidget();
   
   private MaterialLink nameChip;
   private MaterialLink logout;
   
   public LogoutWidget() {
	   setFloat(Float.RIGHT);
	   
	   nameChip = new MaterialLink(
			   "User",
			   new MaterialIcon(IconType.ACCOUNT_CIRCLE)
			   );
	   nameChip.setEnabled(true);
	   nameChip.setIconPosition(IconPosition.LEFT);
	   
	   logout = new MaterialLink("Log out");
	   logout.setIconType(IconType.CANCEL);
	   add(nameChip);
	   add(logout);
   }
   
   public static LogoutWidget get()
   {
	   return instance;
   }
}
