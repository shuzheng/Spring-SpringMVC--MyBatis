package com.shuzheng.ssm.util;

import javax.servlet.http.HttpServletRequest;


/**
 * 分页实用类
 * 
 * @author shuzheng
 * @version 2014/04/21
 * 
 */
public class Paginator {
	
	/**
	 * 生成简单的分页页面内容
	 * 
	 * @param total 总记录数
	 * @param size 每页记录数
	 * @param step 最多显示分页页数
	 * @param page 当前页数
	 * @param request 请求request
	 * @return 分页的HTML代码
	 */
	public static String getSimplePages(long total, int size, int step, int page, HttpServletRequest request, String paramName) {
		// 根据request获取当前url，包括参数，如果有已存在名称未paramname的参数，剔除掉，后面会追加新的参数
		//String contextPath = request.getContextPath();
		//String requestURI = request.getRequestURI();
		//String url = contextPath + requestURI;
		String url = request.getRequestURI();
		String query = request.getQueryString();
		if (query != null) {
			String params = "";
			String[] querys = query.split("&");
			for (int i = 0 ; i < querys.length ; i ++) {
				if (querys[i].startsWith(paramName))
					continue;
				if (params.equals(""))
					params += querys[i];
				else
					params += "&" + querys[i];
			}
			if (!params.equals(""))
				url += "?" + params;
		}
		// 结果html
		String pages = "";

		int pageCount = (int) Math.ceil((double) total / size);// 求总页数
		if (pageCount <= 1) {
			return pages;
		}
		if (page > pageCount) {
			page = pageCount;// 如果分页变量大总页数，则将分页变量设计为总页数
		}
		if (page <= 0) {
			page = 1;// 如果分页变量小于１,则将分页变量设为１
		}
		
		// 显示上一页
		if (page > 1) {
			if (url.contains("?")) {
				pages = pages.concat("<a class=\"prev\" href=\"" + url + "&" + paramName + "=" + (page - 1) + "\">上一页</a>\n");
			} else {
				pages = pages.concat("<a class=\"prev\" href=\"" + url + "?" + paramName + "=" + (page - 1) + "\">上一页</a>\n");
			}
		} else {
			//pages = pages.concat("<a class=\"prev\" href=\"javascript:;\" style=\"color:#ccc\">上一页</a>\n");
		}
		// 如果总页数大于要显示的个数，则拼接显示
		if (pageCount > step) {
			// 显示分页码
			int listBegin = (page - (int) Math.floor((double) step / 2));//从第几页开始显示分页信息
	        if (listBegin < 1) {
	            listBegin = 1;
	        }
	        //显示第1页
			if (listBegin >= 2) {
				if (url.contains("?")) {
					pages = pages.concat("<a href=\"" + url + "&" + paramName + "=1\">1</a> ... \n");
				} else {
					pages = pages.concat("<a href=\"" + url + "?" + paramName + "=1\">1</a> ... \n");
				}
			}
	        //当前页数右侧还有未显示页码时
	        if (pageCount - page >= page - listBegin) {
				for (int i = listBegin; i < (listBegin + step); i++) {
					if (i != page) {
						if (url.contains("?")) {
							pages = pages.concat("<a href=\"" + url + "&" + paramName + "=" + i + "\">" + i + "</a>\n");
						} else {
							pages = pages.concat("<a href=\"" + url + "?" + paramName + "=" + i + "\">" + i + "</a>\n");
						}
					} else {
						pages = pages.concat("<span class=\"current\">" + i + "</span>\n");
					}
				}
		        //显示最后1页
				if (listBegin + step <= pageCount) {
					if (url.contains("?")) {
						pages = pages.concat(" ... <a href=\"" + url + "&" + paramName + "=" + pageCount + "\">" + pageCount + "</a>\n");
					} else {
						pages = pages.concat(" ... <a href=\"" + url + "?" + paramName + "=" + pageCount + "\">" + pageCount + "</a>\n");
					}
				}
	        } else {	// 显示最后剩余的几个页码
	        	for (int i = (pageCount-step) + 1; i <= pageCount; i++) {
					if (i != page) {
						if (url.contains("?")) {
							pages = pages.concat("<a href=\"" + url + "&" + paramName + "=" + i + "\">" + i + "</a>\n");
						} else {
							pages = pages.concat("<a href=\"" + url + "?" + paramName + "=" + i + "\">" + i + "</a>\n");
						}
					} else {
						pages = pages.concat("<span class=\"current\">" + i + "</span>\n");
					}
				}
	        }
		} else { //总页数小于等于step时，直接显示
			for (int i = 1; i <= pageCount; i ++) {
				if (i != page) {
					if (url.contains("?")) {
						pages = pages.concat("<a href=\"" + url + "&" + paramName + "=" + i + "\">" + i + "</a>\n");
					} else {
						pages = pages.concat("<a href=\"" + url + "?" + paramName + "=" + i + "\">" + i + "</a>\n");
					}
				} else {
					pages = pages.concat("<span class=\"current\">" + i + "</span>\n");
				}
			}
		}
		// 显示下一页
		if (page < pageCount) {
			if (url.contains("?")) {
				pages = pages.concat("<a class=\"next\" href=\"" + url + "&" + paramName + "=" + (page + 1) + "\">下一页</a>\n");
			} else {
				pages = pages.concat("<a class=\"next\" href=\"" + url + "?" + paramName + "=" + (page + 1) + "\">下一页</a>\n");
			}
		} else {
			//pages = pages.concat("<a class=\"next\" href=\"javascript:;\" style=\"color:#ccc\">下一页</a>\n");
		}
		return pages;
	}
}
