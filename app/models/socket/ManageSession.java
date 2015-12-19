package models.socket;

import java.util.*;

public class ManageSession{
  static List<SocketSession> socket_sessions = new ArrayList<SocketSession>();
  
  public static void addSession(SocketSession sk){
	  socket_sessions.add(sk);
  }
  
  public static void createSession(String socket_id){
	  SocketSession session = new SocketSession(socket_id);
	  addSession(session);
  }
  
  public static void postTweet(String str){
	  for(SocketSession se: socket_sessions){
		  se.stockTweets(str);
	  }
  }
  
  public static List getTweets(String socket_id){
	  List tmp =  socket_sessions.get(socket_sessions.indexOf(socket_id)).getStockedTweets();
	  socket_sessions.get(socket_sessions.indexOf(socket_id)).clean();
	  return tmp;
  }
}
