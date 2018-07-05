package com.example.springbootdemo.controller;

import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
@ServerEndpoint(value = "/webSocketServer/{userName}")
public class WebSocketServer2 extends TextWebSocketHandler {
	private static final Map<WebSocketSession, String> connections = new ConcurrentHashMap<>();

	private static String getDatetime(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}

	/**
	 * Connection
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {

		String uri = session.getUri().toString();
		String userName = uri.substring(uri.lastIndexOf("/") + 1);

		String nickname = URLDecoder.decode(userName, "utf-8");

		connections.put(session, nickname);
		String message = String.format("* %s %s", nickname, "Join!");

		broadcast(new TextMessage(message));
	}

	/**
	 * Disconnection
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		String nickname = connections.remove(session);
		String message = String.format("* %s %s", nickname, "Exit!");

		broadcast(new TextMessage(message));
	}

	/**
	 * process
	 */
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String msg = "【" + connections.get(session) + "】" + getDatetime(new Date()) + " : " + message.getPayload();

		broadcast(new TextMessage(msg));
	}

	private static void broadcast(TextMessage msg) {
		// send messages
		for (WebSocketSession session : connections.keySet()) {
			try {
				synchronized (session) {
					session.sendMessage(msg);
				}
			} catch (Exception e) {
				connections.remove(session);
				try {
					session.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				String message = String.format("* %s %s", connections.get(session), "connection stopped");
				broadcast(new TextMessage(message));
			}
		}
	}
}
