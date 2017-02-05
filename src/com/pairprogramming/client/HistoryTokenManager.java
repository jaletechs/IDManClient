package com.pairprogramming.client;

public class HistoryTokenManager {
	public static <T> String getTokenPrefix(Class<T> aClass) {

		int prefix = aClass.getClass().getName().hashCode();
		return Integer.toHexString(prefix) + "/";
	}
}
