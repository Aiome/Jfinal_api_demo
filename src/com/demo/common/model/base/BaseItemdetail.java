package com.demo.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseItemdetail<M extends BaseItemdetail<M>> extends Model<M> implements IBean {

	public void setItemDetailID(java.lang.String itemDetailID) {
		set("itemDetailID", itemDetailID);
	}

	public java.lang.String getItemDetailID() {
		return get("itemDetailID");
	}

	public void setNumber(java.lang.String number) {
		set("number", number);
	}

	public java.lang.String getNumber() {
		return get("number");
	}

	public void setItemName(java.lang.String itemName) {
		set("itemName", itemName);
	}

	public java.lang.String getItemName() {
		return get("itemName");
	}

	public void setPrice(java.lang.Double price) {
		set("price", price);
	}

	public java.lang.Double getPrice() {
		return get("price");
	}

}
