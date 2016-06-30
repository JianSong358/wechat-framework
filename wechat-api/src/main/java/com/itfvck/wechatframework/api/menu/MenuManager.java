package com.itfvck.wechatframework.api.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itfvck.wechatframework.core.exception.WeChatException;
import com.itfvck.wechatframework.core.util.WeChatUtil;
import com.itfvck.wechatframework.core.util.http.HttpUtils;

/**
 * 微信菜单操作
 * 
 * @author Zhangxs
 * @version 2015-7-4
 */
public class MenuManager {
	private static Logger logger = LoggerFactory.getLogger(MenuManager.class);

	private static final String MENU_CREATE_POST_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";
	private static final String MENU_GET_GET_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=";
	private static final String MENU_DEL_GET_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=";

	/**
	 * 创建菜单
	 * 
	 * @throws WeChatException
	 */
	public static void create(Menu menu, String accessToken) throws WeChatException {
		logger.info("创建菜单");
		String resultStr = HttpUtils.post(MENU_CREATE_POST_URL + accessToken, JSON.toJSONString(menu));
		WeChatUtil.isSuccess(resultStr);
	}

	/**
	 * 查询菜单
	 */
	public static Menu getMenu(String accessToken) {
		logger.info("查询菜单");
		String resultStr = HttpUtils.get(MENU_GET_GET_URL + accessToken);
		try {
			WeChatUtil.isSuccess(resultStr);
		} catch (WeChatException e) {
			e.printStackTrace();
			return null;
		}
		JSONObject menuObject = JSONObject.parseObject(resultStr);
		Menu menu = menuObject.getObject("menu", Menu.class);
		return menu;
	}

	/**
	 * 删除菜单
	 * 
	 * @throws WeChatException
	 */
	public static void delete(String accessToken) throws WeChatException {
		logger.info("删除菜单");
		String resultStr = HttpUtils.get(MENU_DEL_GET_URL + accessToken);
		WeChatUtil.isSuccess(resultStr);
	}

}
