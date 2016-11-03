/** 
* 文件名称:.java
* 姓		名:马红岩
* 学		号:2014011791
* 班		级:6班
* 时		间:2016年10月17日
* 程序说明:
*			
**/ 
package com.demo.api.order;


import com.demo.api.BaseAPIController;
import com.demo.common.model.Order;
import com.demo.util.IDFactoty;
import com.jfinal.aop.Before;
import com.jfinal.render.FreeMarkerRender;

import freemarker.template.TemplateModelException;


@Before(OrderInterceptor.class)
public class OrderController extends BaseAPIController{
	public void index() {
		setAttr("orderPage", Order.dao.paginate(getParaToInt(0, 1), 10));
		render("order.html");
	}
	
	public void add() {
		try {
			FreeMarkerRender.getConfiguration().setSharedVariable("setOrderID",new IDFactoty());
		} catch (TemplateModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Before(OrderValidator.class)
	public void save() {
		getModel(Order.class).save();
		redirect("/api/order");
	}
	
	
	public void edit() {
		setAttr("order", Order.dao.findById(getParaToLong()));
	}
	
	@Before(OrderValidator.class)
	public void update() {
		getModel(Order.class).update();
		redirect("/api/order");
	}
	
	public void delete() {
		Order.dao.deleteById(getParaToLong());
		redirect("/api/order");
	}
	
}
