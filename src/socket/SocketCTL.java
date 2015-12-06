package socket;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint(value = "/websocket")
public class SocketCTL {
    private static Set<Session> ses = new CopyOnWriteArraySet<>();
    @OnOpen
    public void onOpen(Session session){
                ses.add(session);
                sendMessage("this is test");
            }
    
    @OnMessage
    public void onMessage(String text){
            if(text.equals("bot")){
             }else{
                sendMessage(text);
             }
        }
    
    @OnClose
        public void onClose(Session session){
                ses.remove(session);
        } 

    public static void sendMessage(String msg){
            for(Session ses :ses){
                    ses.getAsyncRemote().sendText(msg);
            }
    }
//  @OnError
//  //  public void onError(Session session, Throwable thr) {} 
//      
}
