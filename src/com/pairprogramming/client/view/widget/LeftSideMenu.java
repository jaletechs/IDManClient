package com.pairprogramming.client.view.widget;

import gwt.material.design.client.constants.CollapsibleType;
import gwt.material.design.client.constants.IconSize;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialCollapsible;
import gwt.material.design.client.ui.MaterialCollapsibleBody;
import gwt.material.design.client.ui.MaterialCollapsibleHeader;
import gwt.material.design.client.ui.MaterialCollapsibleItem;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialPanel;

import java.util.List;

import com.pairprogramming.client.dto.PrivilegeDto;
import com.pairprogramming.client.dto.RoleDto;

public class LeftSideMenu extends MaterialCollapsible{
	private static final LeftSideMenu singleton = new LeftSideMenu();
	
	public LeftSideMenu(){
		setAccordion(true);
		setType(CollapsibleType.FLAT);
		setShadow(1);
	}
	
	public void createMenus(List<RoleDto> benefits){
		for(RoleDto dto: benefits){
			MaterialCollapsibleItem benefit = new MaterialCollapsibleItem();
			MaterialCollapsibleHeader header = new MaterialCollapsibleHeader();
			header.addStyleName("headerme");
			MaterialCollapsibleBody body = new MaterialCollapsibleBody();
			
			MaterialLink head = new MaterialLink(dto.getRoleName());
			head.setIconType(IconType.ACCOUNT_CIRCLE);
			head.setIconSize(IconSize.LARGE);
			head.addStyleName("link");
			header.add(head);
			
			benefit.add(header);
			benefit.add(body);
		
			if(dto.getPrivileges().isEmpty()|| dto.getPrivileges()==null)
				break;
			
			List<PrivilegeDto> privs = dto.getPrivileges();
			MaterialPanel panel = new MaterialPanel();
			
			for(PrivilegeDto priv: privs){
				MenuItem link = new MenuItem(priv);
				panel.add(link);
			}
			body.add(panel);
			benefit.add(body);
			
			add(benefit);
		}
	}
	
	public static LeftSideMenu get(){
		return singleton;
	}
}