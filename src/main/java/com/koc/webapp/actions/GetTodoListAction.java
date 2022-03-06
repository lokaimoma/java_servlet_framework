package com.koc.webapp.actions;

import java.util.List;
import java.util.Map;

import com.koc.webapp.business.DefaultService;
import com.koc.webapp.entities.Todo;
import com.koc.webapp.utils.Result;
import com.koc.webapp.utils.Result.Error;
import com.koc.webapp.utils.Result.Success;

public class GetTodoListAction implements Action {

	@Override
	public Result execute(Map<String, String[]> params) {
		try {
			List<Todo> todos = DefaultService.getInstance().getTodos();
			return new Result.Success<List<Todo>>(todos);
		}catch(Exception e) {
			return new Result.Error(e.getMessage());
		}
	}

}
