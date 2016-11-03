package com.demo.api.item;

import com.demo.common.model.Item;
import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
 * BlogValidator.
 */
public class ItemValidator extends Validator {
	
	protected void validate(Controller controller) {
	}
	@Override
	protected void handleError(Controller controller) {
		controller.keepModel(Item.class);
		
		String actionKey = getActionKey();
		if (actionKey.equals("/api/item/save"))
			controller.render("add.html");
		else if (actionKey.equals("/api/item/update"))
			controller.render("edit.html");
	}
}
