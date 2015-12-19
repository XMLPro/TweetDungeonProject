package controllers;

import play.*;
import play.mvc.Http.WebSocketClose;
import play.mvc.Http.WebSocketEvent;
import play.mvc.WebSocketController;

import java.util.*;

import models.*;

public class WebSocket extends WebSocketController {
	public static void sendms(){
		CheckStreaming cs = CheckStreaming.getInstance();
		while(inbound.isOpen()){
			WebSocketEvent e = await(inbound.nextEvent());
			
			for(String update: e.TextFrame.and(e.TextFrame.Equals("update")).match(e)){
				for(String twi: cs.getTwis()){
						outbound.send(twi);
				}
			}
			for(String connect: e.TextFrame.and(e.TextFrame.Equals("connect")).match(e)){
				cs.connect(session.getId());
			}
			for(WebSocketClose closed: e.SocketClosed.match(e)) {
				cs.disconnect(session.getId());
				Logger.info("Socket closed!");
			}
		}
	}

	public static void sendpoint(){
		while(inbound.isOpen()){

		}
	}
}
