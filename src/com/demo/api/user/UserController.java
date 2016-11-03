/** 
* 文件名称:.java
* 姓		名:马红岩
* 学		号:2014011791
* 班		级:6班
* 时		间:2016年10月17日
* 程序说明:
*			
**/ 
package com.demo.api.user;

import java.util.HashMap;
import java.util.List;

import com.demo.api.BaseAPIController;
import com.demo.bean.BaseResponse;
import com.demo.bean.Code;
import com.demo.bean.DatumResponse;
import com.demo.bean.Require;
import com.demo.common.model.Order;
import com.demo.common.model.User;
import com.demo.util.IDFactoty;
import com.demo.util.StringUtils;
import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.render.FreeMarkerRender;

import freemarker.template.TemplateModelException;

@Before(UserInterceptor.class)
public class UserController extends BaseAPIController{
	public void index() {
		setAttr("userPage", User.dao.paginate(getParaToInt(0, 1), 10));
		render("user.html");
	}
	
	public void add() {
		try {
			FreeMarkerRender.getConfiguration().setSharedVariable("setID",new IDFactoty());
		} catch (TemplateModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Before(UserValidator.class)
	public void save() {
		getModel(User.class).save();
		redirect("/api/user");
	}
	
	
	public void edit() {
		setAttr("user", User.dao.findById(getParaToLong()));
	}
	
	@Before(UserValidator.class)
	public void update() {
		getModel(User.class).update();
		redirect("/api/user");
	}
	
	public void delete() {
		User.dao.deleteById(getParaToLong());
		redirect("/api/user");
	}
	/**
	 * 获取用户资料
	 */
	public void info(){
		String userId = getPara("userID");
		System.out.println(userId);
        User resultUser = null;
        if (StringUtils.isNotEmpty(userId)) {
            resultUser = User.dao.findById(userId);
        } else {
            resultUser = getUser();
        }

        DatumResponse response = new DatumResponse();
        
        if (resultUser == null) {
            response.setCode(Code.FAIL).setMessage("user is not found");
        } else {
            HashMap<String, Object> map = new HashMap<String, Object>(resultUser.getAttrs());
            map.remove("password");
            response.setDatum(map);
            resultUser = User.dao.findById(userId);
        }

        renderJson(response);
	}
	/*
	 * 获取用户address
	 */
	public void address(){
		String userId = getPara("userID");
        User resultUser = null;
        if (StringUtils.isNotEmpty(userId)) {
            resultUser = User.dao.findById(userId);
        } else {
            resultUser = getUser();
        }

        DatumResponse response = new DatumResponse();
        
        if (resultUser == null) {
            response.setCode(Code.FAIL).setMessage("user is not found");
        } else {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("userID", resultUser.getUserID());
            map.put("name", resultUser.getName());
            map.put("addressID", resultUser.getAddressID());
            map.remove("password");
            response.setDatum(map);
            resultUser = User.dao.findById(userId);
        }

        renderJson(response);
	}
	/**
	 * 获取用户所有订单
	 */
	public void order(){
		String userId = getPara("userID");
		 DatumResponse response = new DatumResponse();
        List<Order> lo = Order.dao.find("select * from `order` where userID="+"\""+ userId + "\"");
        
        if(lo.isEmpty()){
        	response.setCode(Code.FAIL).setMessage("not find a suitable order");
        }else {
        	response.setDatum(lo);
        }
        renderJson(response);
	}
	public void register(){
		//必填信息
		String name = getPara("name");//登录帐号
        String password = getPara("password");//密码

        //校验必填项参数
		if(!notNull(Require.me()
                .put(name, "name can not be null")
                .put(password, "password can not be null"))){
			return;
		}

        //检查账户是否已被注册
        if (Db.findFirst("SELECT * FROM user WHERE name=?", name) != null) {
            renderJson(new BaseResponse(Code.ACCOUNT_EXISTS, "user already registered"));
            return;
        }
        
		//保存用户数据
		String userID = IDFactoty.produceUserID()+"";

		new User()
                .set("userID", userID)
                .set("name", name)
		        .set("password", StringUtils.encodePassword(password, "md5"))
                .save();
        
		//返回数据
		renderJson(new BaseResponse("success"));
			
	}
	
}
