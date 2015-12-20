package models.socket;

import java.util.ArrayList;
import java.util.List;

public class SocketSession {
	private String socket_id;
	private List<String> tweets = new ArrayList<String>();

	public SocketSession(String socket_id){
		this.socket_id = socket_id;
	}

	public void stockTweets(String tweet){
		tweets.add(tweet);
	}

	public List getStockedTweets(){
		return tweets;
	}

	public void removeStockedTweet(String str){
		tweets.remove(tweets.indexOf(str));
	}

	public String getSocketId(){
		return socket_id;
	}

	public void clean(){
		tweets.clear();
	}
    public String toString(){
        return this.socket_id;
    }

}
