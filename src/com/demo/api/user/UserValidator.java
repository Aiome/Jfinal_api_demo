package com.demo.api.user;

import com.demo.common.model.User;
import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
 * BlogValidator.
 */
public class UserValidator extends Validator {
	
	protected void validate(Controller controller) {
		validateRequiredString("user.name", "nameMsg", "请输入User昵称!");
		validateRequiredString("user.password", "passwordMsg", "请输入User密码!");
	}
	@Override
	protected void handleError(Controller controller) {
		controller.keepModel(User.class);
		
		String actionKey = getActionKey();
		if (actionKey.equals("/api/user/save"))
			controller.render("add.html");
		else if (actionKey.equals("/api/user/update"))
			controller.render("edit.html");
	}
}
