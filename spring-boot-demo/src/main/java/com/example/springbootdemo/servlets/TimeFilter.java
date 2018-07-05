package com.example.springbootdemo.servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter("/*")
public class TimeFilter implements Filter {
	Logger LOGGER = LoggerFactory.getLogger(TimeFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		LOGGER.debug("==========TimeFilter init ==========");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		long start = System.currentTimeMillis();
		filterChain.doFilter(request, response);
		LOGGER.debug("TimeFilter:" + (System.currentTimeMillis() - start));
	}

	@Override
	public void destroy() {
		LOGGER.debug("==========TimeFilter destroy ==========");

	}

}
