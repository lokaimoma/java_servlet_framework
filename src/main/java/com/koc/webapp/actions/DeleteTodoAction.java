package com.koc.webapp.actions;

import java.util.Map;

import com.koc.webapp.business.DefaultService;
import com.koc.webapp.utils.Result;

public class DeleteTodoAction implements Action {

	@Override
	public Result execute(Map<String, String[]> params) {
		try {
			String[] todoId = params.get("id");
			DefaultService.getInstance().deleteTodo(Integer.valueOf(Action.join(todoId)));
			return new Result.Success<String>("Todo deleted successfully");
		}catch(Exception e) {
			return new Result.Error(e.getMessage());
		}
	}

}
