package com.pairprogramming.client.cache;

import com.google.gwt.user.client.ui.Image;
import com.pairprogramming.client.dto.UserDto;

public class CacheManager {
	
	private static UserDto userDto;
	private static Image image = new Image("/images/arrow.png");
	
	public CacheManager(){
		userDto = getActiveUser();
	}
	
	public static Image getArrow(){
		image.setSize("100%", "100%");
		return image;
	}
	
	public static UserDto getActiveUser(){
		return userDto;
	}
	
	public static void setActiveUser(UserDto user){
		userDto = user;
	}
}//CacheManager
