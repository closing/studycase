package com.example.springbootdemo.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class ListenerTest implements ServletContextListener {
	Logger LOGGER = LoggerFactory.getLogger(ListenerTest.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		LOGGER.debug("========== ServletContext init ==========");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		LOGGER.debug("========== ServletContext destroy ==========");

	}

}
