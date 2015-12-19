package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class WebSocket extends WebSocketController {
	public static void sendms(){
		CheckStreaming cs = CheckStreaming.getInstance();
		while(inbound.isOpen()){
			WebSocketEvet e = await(inbound.nextEvent());
			for(String update: TextFrame.and(Equals("update")).match(e)){
				for(String str: cs.getTwis()){
						outbound.send(twis);
				}
			}
			for(String connect: TextFrame.and(Equals("connect")).match(e)){
				cs.connect(session.getId());
			}
			for(WebSocketClose closed: SocketClosed.match(e)) {
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
