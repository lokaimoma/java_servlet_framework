package com.koc.webapp.actions;

import java.util.Map;

import com.koc.webapp.utils.Result;

public interface Action {
	public Result execute(Map<String, String[]> params);
	public static String join(String[] field) {
		return String.join("", field);
	}
}
