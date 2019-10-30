package com.freesun.votemanager.config;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freesun.votemanager.util.ResultObj;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;


public class ShiroLoginFilter extends FormAuthenticationFilter {
	/**
	 * 当用户访问未登陆资源时，会走的方法。
	 * 返回true代表已登陆，不用处理
	 * 返回false代表未登陆。提示前端
	 */
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		//判断用户是否是浏览器访问
		if(isAjax(request)) {

			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(ResultObj.fail().add("loginInfo","未登录").toString());
			out.flush();
			out.close();
		}else {//重定向
			HttpServletResponse httpServletResponse=(HttpServletResponse) response;
			httpServletResponse.sendRedirect("/index.html");
		}
		
		return false;
	}
	
	/**
	 * 判断当前请求是否为ajax请求
	 * @param request
	 * @return
	 */
	private boolean isAjax(ServletRequest request) {
		String header = ((HttpServletRequest) request).getHeader("X-Requested-With");
		if ("XMLHttpRequest".equalsIgnoreCase(header)) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
}
