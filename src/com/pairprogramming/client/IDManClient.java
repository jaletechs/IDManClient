package com.pairprogramming.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.pairprogramming.client.dto.PrivilegeDto;
import com.pairprogramming.client.dto.RoleDto;
import com.pairprogramming.client.view.AppLayoutView;
import com.pairprogramming.client.view.CenterView;
import com.pairprogramming.client.view.widget.LeftSideMenu;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class IDManClient implements EntryPoint {
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		SimpleEventBus eventBus = EventManager.getEventBus();
		AppController appViewer = new AppController(eventBus);
		
		cacheObjects();
		
		Element body = Document.get().getBody();
		Element loading = Document.get().getElementById("loading");
		if(body.isOrHasChild(loading)){
			loading.removeFromParent();
		}
		
		setUp(appViewer);
	}
	
	private void setUp(final AppController appViewer){
//		UserMngrService.Util.getService().getAllRoles(new AsyncCallback<List<RoleDto>>(){
//
//			@Override
//			public void onFailure(Throwable caught) {
//				Window.alert("App failed to Start!!!");
//			}
//
//			@Override
//			public void onSuccess(List<RoleDto> result) {
//				LeftSideMenu.get().createMenus(result);
//				RootLayoutPanel.get().add(AppLayoutView.get());
//				appViewer.go(CenterView.get());
//			}
//			
//		});
		
		LeftSideMenu.get().createMenus(getDummyList());
		
		RootLayoutPanel.get().add(AppLayoutView.get());
		appViewer.go(CenterView.get());
		
	}
	
	private List<RoleDto> getDummyList(){
		List<RoleDto> roles = new ArrayList<>();
		
		PrivilegeDto privilege = new PrivilegeDto();
		privilege.setPrivilegeId(1);
		privilege.setDescription("Manage ID Generation");
		
		RoleDto role = new RoleDto();
		role.setRoleId(1);
		role.setDescription("ID Card Manager");
		role.setRoleName("ID Card Manager");
		List<PrivilegeDto> privileges = new ArrayList<>();
		privileges.add(privilege);
		
		role.setPrivileges(privileges);
		roles.add(role);
		
		return roles;
	}
	
	
	private void cacheObjects(){
//		UserMngrService.Util.getService().getLoggedInUser(new AsyncCallback<UserDto>(){
//
//			@Override
//			public void onFailure(Throwable caught) {
//				Window.alert("Couldn't Cache User");
//			}
//
//			@Override
//			public void onSuccess(UserDto result) {
//				CacheManager.setActiveUser(result);
//			}
//			
//		});
	}
}
