package com.koc.webapp.actions;

import java.util.Map;

import com.koc.webapp.business.DefaultService;
import com.koc.webapp.entities.Todo;
import com.koc.webapp.utils.Result;

public class AddTodoAction implements Action {

	@Override
	public Result execute(Map<String, String[]> params) {
		int paramsSize = params.size();
		if (paramsSize <= 0) return new Result.Success<Void>();
		try {
			String[] title = params.get("title");
			String[] description = params.get("description");
			String[] dateTime = params.get("date-time");
			DefaultService.getInstance().insertTodo(new Todo(Action.join(title), Action.join(description), Action.join(dateTime)));
			return new Result.Success<String>("Todo added successfully");
		}catch(Exception e) {
			e.printStackTrace();
			return new Result.Error(e.getMessage());
		}
	}

}
