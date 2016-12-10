package club.xmlpro.twitter;

import club.xmlpro.config.TwitterConfig;
import club.xmlpro.event.AnalyzeEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import twitter4j.*;

public class TwitterListener implements StatusListener{
    private static final Logger logger = LoggerFactory.getLogger(TwitterListener.class);
    @Autowired
    private ApplicationEventPublisher publisher;

    @Override
    public void onStatus(Status status) {
        //String tweet = status.getText();
        //String analyzeText = tweet.replace(TwitterConfig.TWITTER_ACCOUNT, "");
        publisher.publishEvent(new AnalyzeEvent(this));
    }

    @Override
    public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {

    }

    @Override
    public void onTrackLimitationNotice(int i) {

    }

    @Override
    public void onScrubGeo(long l, long l1) {

    }

    @Override
    public void onStallWarning(StallWarning stallWarning) {

    }

    @Override
    public void onException(Exception e) {

    }
}
