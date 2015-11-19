package hashGet;

import twitter4j.TwitterStream;

public class Main{
	public static void main(String[] args) {
		MyStatusListener listener = new MyStatusListener();
		// 大人数時の投票システム
		Thread t1 = new Thread(listener);
		t1.start();
		// ハッシュタグのツイート取得
		TwitterStream get_twitterStreaming = listener
				.getTwitterStreaming();
	}
}
