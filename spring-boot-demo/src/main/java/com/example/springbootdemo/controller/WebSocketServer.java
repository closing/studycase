package com.example.springbootdemo.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

@Component
@ServerEndpoint(value = "/webSocketServer/{userName}")
public class WebSocketServer {
	private static final Set<WebSocketServer> connections = new CopyOnWriteArraySet<>();

	private String nickname;
	private Session session;

	private static String getDatetime(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}

	@OnOpen
	public void start(@PathParam("userName") String userName, Session session) {
		this.nickname = userName;
		this.session = session;
		connections.add(this);
		String message = String.format("* %s %s", nickname, "Join！");
		broadcast(message);
	}

	@OnClose
	public void end() {
		connections.remove(this);
		String message = String.format("* %s %s", nickname, "Exit！");
		broadcast(message);
	}

	@OnMessage
	public void pushMsg(String message) {
		broadcast("【" + this.nickname + "】" + getDatetime(new Date()) + " : " + message);
	}

	@OnError
	public void onError(Throwable t) throws Throwable {

	}

	private static void broadcast(String msg) {
		// Send message
		for (WebSocketServer client : connections) {
			try {
				synchronized (client) {
					client.session.getBasicRemote().sendText(msg);
				}
			} catch (IOException e) {
				connections.remove(client);
				try {
					client.session.close();
				} catch (IOException e1) {
					e.printStackTrace();
				}
				String message = String.format("* %s %s", client.nickname, "Connetion stopped");
				broadcast(message);
			}
		}
	}
}
