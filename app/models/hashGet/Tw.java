package models.hashGet;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class Tw {
    public TwitterStream getTwitterStreaming(){
        MyStatusListener listener = new MyStatusListener();
                // 大人数時の投票システム
        Thread t1 = new Thread(listener);
        t1.start();
        // ハッシュタグのツイート取得
        return listener.getTwitterStreaming();
    }
}

