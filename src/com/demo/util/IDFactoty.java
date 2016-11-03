/** 
* 文件名称:.java
* 姓		名:马红岩
* 学		号:2014011791
* 班		级:6班
* 时		间:2016年10月21日
* 程序说明:
*			
**/ 
package com.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.demo.common.model.Item;

public class IDFactoty {
	public static long produceUserID(){
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return Long.valueOf(df.format(date));
	}
	public static long produceOrderID(){
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return Long.valueOf(df.format(date));
	}
	public static long produceItemID(){
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		return Long.valueOf(df.format(date));
	}
	public static void main(String[] args) {
		System.out.println(IDFactoty.produceUserID());
	}
}
