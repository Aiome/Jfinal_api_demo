package com.demo.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseItem<M extends BaseItem<M>> extends Model<M> implements IBean {

	public void setItemID(java.lang.String itemID) {
		set("itemID", itemID);
	}

	public java.lang.String getItemID() {
		return get("itemID");
	}

	public void setTitle(java.lang.String title) {
		set("title", title);
	}

	public java.lang.String getTitle() {
		return get("title");
	}

	public void setPic(java.lang.String pic) {
		set("pic", pic);
	}

	public java.lang.String getPic() {
		return get("pic");
	}

	public void setPrice(java.lang.Double price) {
		set("price", price);
	}

	public java.lang.Double getPrice() {
		return get("price");
	}

	public void setExpressPrice(java.lang.Double expressPrice) {
		set("expressPrice", expressPrice);
	}

	public java.lang.Double getExpressPrice() {
		return get("expressPrice");
	}

	public void setSale(java.lang.Integer sale) {
		set("sale", sale);
	}

	public java.lang.Integer getSale() {
		return get("sale");
	}

	public void setOrigin(java.lang.String origin) {
		set("origin", origin);
	}

	public java.lang.String getOrigin() {
		return get("origin");
	}

	public void setBrand(java.lang.String brand) {
		set("brand", brand);
	}

	public java.lang.String getBrand() {
		return get("brand");
	}

	public void setYear(java.lang.String year) {
		set("year", year);
	}

	public java.lang.String getYear() {
		return get("year");
	}

	public void setMeterial(java.lang.String meterial) {
		set("meterial", meterial);
	}

	public java.lang.String getMeterial() {
		return get("meterial");
	}

	public void setCommonID(java.lang.String commonID) {
		set("commonID", commonID);
	}

	public java.lang.String getCommonID() {
		return get("commonID");
	}

	public void setDetailID(java.lang.String detailID) {
		set("detailID", detailID);
	}

	public java.lang.String getDetailID() {
		return get("detailID");
	}

}
