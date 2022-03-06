package com.koc.webapp.actions;

import java.util.Map;

import com.koc.webapp.business.DefaultService;
import com.koc.webapp.entities.Todo;
import com.koc.webapp.utils.Result;
import com.koc.webapp.utils.Result.Error;
import com.koc.webapp.utils.Result.Success;

public class EditTodoAction implements Action {

	@Override
	public Result execute(Map<String, String[]> params) {
		int paramSize= params.size();
		try {
			if (paramSize == 1) {
				String[] todoId = params.get("id");
				Todo todo = DefaultService.getInstance().getTodo(Integer.valueOf(Action.join(todoId)));
				if (todo == null) throw new IllegalStateException("Todo doesn't exist");
				return new Result.Success<Todo>(todo);
			}else if (paramSize <= 0) {
				throw new IllegalStateException("No params received");
			}else {
				String[] todoId = params.get("id");
				String[] title = params.get("title");
				String[] description = params.get("description");
				String[] dateTime = params.get("date-time");
				DefaultService.getInstance().updateTodo(new Todo(Integer.valueOf(Action.join(todoId)), Action.join(title), Action.join(description), Action.join(dateTime)));
				return new Result.Success<String>("Todo updated successfully");
			}
		}catch(Exception e) {
			return new Result.Error(e.getMessage());
		}
	}

}
