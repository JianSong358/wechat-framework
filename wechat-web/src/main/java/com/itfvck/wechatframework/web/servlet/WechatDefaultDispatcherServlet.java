package com.itfvck.wechatframework.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itfvck.wechatframework.core.common.BaseParams;
import com.itfvck.wechatframework.core.common.WechatParam;
import com.itfvck.wechatframework.core.util.SignatureUtil;

/**
 * 默认微信消息请求入口
 * 
 * @author
 *
 */
class WechatDefaultDispatcherServlet extends WechatFrameworkServlet {
	private static final long serialVersionUID = -9199915074190263799L;
	static Logger logger = LoggerFactory.getLogger(WechatDefaultDispatcherServlet.class);

	BaseParams baseParams = null;

	/**
	 * 微信接入验证请求入口
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WechatParam params = new WechatParam(request);
		logger.info("GET params：" + params.toString());
		PrintWriter out = null;
		try {
			out = response.getWriter();
			// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
			if (SignatureUtil.checkSignature(params, baseParams)) {
				out.print(params.getEchostr());
			} else {
				out.print("params=" + params.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("IOException错误", e.getMessage());
		} finally {
			if (out != null) {
				out.flush();
				out.close();
			}
			out = null;
		}
	}

	/**
	 * 微信消息接收入口
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WechatParam params = new WechatParam(request);
		logger.info("POST params：" + params.toString());
		PrintWriter out = null;
		String xml = null;
		try {
			out = response.getWriter();
			// 调用核心服务类接收处理请求
			xml = getWechatService().service(request, baseParams, params);
			out.print(xml);
		} catch (Exception e) {
			logger.error("核心服务类接收处理请求错误", xml + "\n" + e);
		} finally {
			if (out != null) {
				out.flush();
				out.close();
				out = null;
			}
		}
	}

}
