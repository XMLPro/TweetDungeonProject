package controllers;

import play.*;
import play.mvc.Http.WebSocketClose;
import play.mvc.Http.WebSocketEvent;
import play.mvc.Scope.Session;
import play.mvc.WebSocketController;

import play.mvc.Http.WebSocketClose;
import play.mvc.Http.WebSocketEvent;
import play.mvc.Http.WebSocketFrame;
import play.mvc.WebSocketController;

import java.util.*;

import models.*;
import models.socket.ManageSession;

public class WebSocket extends WebSocketController {
	public static void sendms(){
		while(inbound.isOpen()){
            Logger.info("sendmes()");
			ManageSession.createSession(session.getId());
			WebSocketEvent e = await(inbound.nextEvent());
			 if(e instanceof WebSocketFrame) {
                  WebSocketFrame frame = (WebSocketFrame)e;
                  if(!frame.isBinary) {
                      if(frame.textData.equals("updatemap")) {
                          String str="";
                          int map[][] = Init.maze1.getMap();
                          for(int i=0;i<map.length;i++){
                              for(int j=0;j<map[i].length;j++){
                                  str += map[i][j] + " ";
                              }
                              str = str.substring(0,str.length()-1);
                              str += ":";
                          }
        Logger.info(str);

                          outbound.send(str);
                      }
                      if(frame.textData.equals("update")) {
						List<String> se = ManageSession.getTweets(session.getId());
						if(!((ArrayList)se).isEmpty()){
							for(String str: (ArrayList<String>)se){
								outbound.send(str);
							}
						}
                      }
                  }else{
                      System.out.println("------------");
                  }
             }
			if(e instanceof WebSocketClose) {
	            Logger.info("Socket closed!");
				ManageSession.removeSession(session.getId());
	        }
		}
	}

}
