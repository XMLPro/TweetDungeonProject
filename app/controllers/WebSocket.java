package controllers;

import play.*;
import play.mvc.Http.WebSocketClose;
import play.mvc.Http.WebSocketEvent;
import play.mvc.Scope.Session;
import play.mvc.WebSocketController;

import java.util.*;

import models.*;
import models.socket.ManageSession;

public class WebSocket extends WebSocketController {
	public static void sendms(){
		while(inbound.isOpen()){
			ManageSession.createSession(session.getId());
			WebSocketEvent e = await(inbound.nextEvent());
			 if(e instanceof WebSocketFrame) {
                  WebSocketFrame frame = (WebSocketFrame)e;
                  if(!e.isBinary) {
                      if(frame.textData.equals("update")) {
						List<String> se = ManageSession.getTweets(session.getId());
						if(!((ArrayList)se).isEnpty()){
							for(String str: (ArrayList<String>)se){
								outbound.send(str);
							}
						}
                      } 
                  }
             }
			if(e instanceof WebSocketClose) {
	            Logger.info("Socket closed!");
				ManageSession.removeSession(session.getId());	
	        }
		}
	}

	public static void sendpoint(){
		while(inbound.isOpen()){

		}
	}
}
