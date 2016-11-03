/** 
* 文件名称:.java
* 姓		名:马红岩
* 学		号:2014011791
* 班		级:6班
* 时		间:2016年10月17日
* 程序说明:
*			
**/ 
package com.demo.api.item;


import java.util.HashMap;
import java.util.List;

import com.demo.api.BaseAPIController;
import com.demo.bean.Code;
import com.demo.bean.DatumResponse;
import com.demo.common.model.Item;
import com.demo.common.model.Order;
import com.demo.common.model.User;
import com.demo.util.IDFactoty;
import com.demo.util.StringUtils;
import com.jfinal.aop.Before;
import com.jfinal.render.FreeMarkerRender;

import freemarker.template.TemplateModelException;


@Before(ItemInterceptor.class)
public class ItemController extends BaseAPIController{
	public void index() {
		setAttr("itemPage", Item.dao.paginate(getParaToInt(0, 1), 10));
		render("item.html");
	}
	
	public void add() {
		try {
			FreeMarkerRender.getConfiguration().setSharedVariable("setItemID",new IDFactoty());
		} catch (TemplateModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Before(ItemValidator.class)
	public void save() {
		getModel(Item.class).save();
		redirect("/api/item");
	}
	
	
	public void edit() {
		setAttr("item", Item.dao.findById(getParaToLong()));
	}
	
	@Before(ItemValidator.class)
	public void update() {
		getModel(Item.class).update();
		redirect("/api/item");
	}
	
	public void delete() {
		Item.dao.deleteById(getParaToLong());
		redirect("/api/item");
	}
	
	public void info(){
		String itemId = getPara("itemID");
        Item resultItem = null;
        if (StringUtils.isNotEmpty(itemId)) {
        	resultItem = Item.dao.findById(itemId);
        }

        DatumResponse response = new DatumResponse();
        
        if (resultItem == null) {
            response.setCode(Code.FAIL).setMessage("item is not found");
        } else {
            HashMap<String, Object> map = new HashMap<String, Object>(resultItem.getAttrs());
            response.setDatum(map);
            resultItem = Item.dao.findById(itemId);
        }

        renderJson(response);
	}
	
	public void allItem(){
		List<Item> li = Item.dao.find("select * from `item`");
		DatumResponse response = new DatumResponse();
		if(li.isEmpty()){
        	response.setCode(Code.FAIL).setMessage("no item");
        }else {
        	response.setDatum(li);
        }
        renderJson(response);		
	}
	
}
