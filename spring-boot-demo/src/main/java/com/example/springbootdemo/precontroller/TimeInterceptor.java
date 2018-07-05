package com.example.springbootdemo.precontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TimeInterceptor implements HandlerInterceptor {
	Logger LOGGER = LoggerFactory.getLogger(TimeInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		LOGGER.debug("========== preHandle ==========");
		//LOGGER.debug(((HandlerMethod) handler).getBean().getClass().getName());
		//LOGGER.debug(((HandlerMethod) handler).getMethod().getName());

		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		LOGGER.debug("========== postHandle ==========");
		Long start = (Long) request.getAttribute("startTime");
		LOGGER.debug("Times:" + (System.currentTimeMillis() - start));
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
		LOGGER.debug("========== afterCompletion ==========");
		Long start = (Long) request.getAttribute("startTime");
		LOGGER.debug("Times:" + (System.currentTimeMillis() - start));

		LOGGER.debug((ex == null ? "null" : ex.toString()));
	}

}
