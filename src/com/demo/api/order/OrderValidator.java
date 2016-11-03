package com.demo.api.order;

import com.demo.common.model.Order;
import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
 * BlogValidator.
 */
public class OrderValidator extends Validator {
	
	protected void validate(Controller controller) {
		validateRequiredString("order.name", "nameMsg", "请输入UserID昵称!");
		validateRequiredString("order.password", "passwordMsg", "请输入itemID!");
	}
	@Override
	protected void handleError(Controller controller) {
		controller.keepModel(Order.class);
		
		String actionKey = getActionKey();
		if (actionKey.equals("/api/order/save"))
			controller.render("add.html");
		else if (actionKey.equals("/api/order/update"))
			controller.render("edit.html");
	}
}
