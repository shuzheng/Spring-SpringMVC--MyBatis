package com.shuzheng.ssm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * skip non-http requests
 * 
 * @author shuzheng
 * @version 2014/04/14
 *
 */
public class DisableUrlSessionFilter implements Filter {

	/**
	 * Filters requests to disable URL-based session identifiers.
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// skip non-http requests
		if (!(request instanceof HttpServletRequest)) {
			chain.doFilter(request, response);
			return;
		}
		// HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		// clear session if session id in URL

		/*String fromURL = httpRequest.getHeader("Referer");
		System.out.println(fromURL);
		if (fromURL != null) {
			if (fromURL.indexOf(";jsessionid=") > 0) {
				// HttpSession session = httpRequest.getSession();
				// if (session != null) {
				// session.invalidate();
				// }
				fromURL = fromURL.substring(0, fromURL.indexOf(";") - 1);
			}
		}
		System.out.println(fromURL);*/

		// wrap response to remove URL encoding
		HttpServletResponseWrapper wrappedResponse = new HttpServletResponseWrapper(httpResponse) {
			@Override
			public String encodeRedirectUrl(String url) {
				return url;
			}

			@Override
			public String encodeRedirectURL(String url) {
				return url;
			}

			@Override
			public String encodeUrl(String url) {
				return url;
			}

			@Override
			public String encodeURL(String url) {
				return url;
			}
		};
		chain.doFilter(request, wrappedResponse);
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

	public void destroy() {
	}

}
