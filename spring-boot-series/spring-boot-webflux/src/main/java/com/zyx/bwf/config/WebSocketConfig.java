package com.zyx.bwf.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;

import com.zyx.bwf.component.websocket.EchoHandler;

@Configuration
public class WebSocketConfig {

	@Bean
	@Autowired
	public HandlerMapping webSocketMapping(final EchoHandler echoHandler) {
		final Map<String, WebSocketHandler> map = new HashMap<>();
		map.put("/echo", echoHandler);

		final SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
		mapping.setOrder(Ordered.HIGHEST_PRECEDENCE);
		mapping.setUrlMap(map);
		return mapping;

	}

	@Bean
	public WebSocketHandlerAdapter handlerAdapter() {
		return new WebSocketHandlerAdapter();

	}
}
