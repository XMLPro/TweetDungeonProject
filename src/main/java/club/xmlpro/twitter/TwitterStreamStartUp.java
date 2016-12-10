package club.xmlpro.twitter;


import club.xmlpro.config.TwitterConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

@Component
public class TwitterStreamStartUp {
    @Autowired
    ApplicationEventPublisher publisher;

    @Autowired
    private StatusListener statusListener;

    @EventListener
    public void start(ApplicationReadyEvent event) {
        Configuration configuration = new ConfigurationBuilder()
                .setOAuthConsumerKey(TwitterConfig.CONSUMER_KEY)
                .setOAuthConsumerSecret(TwitterConfig.CONSUMER_KEY_SECRET)
                .setOAuthAccessToken(TwitterConfig.ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(TwitterConfig.ACCESS_TOKEN_SECRET)
                .build();

        TwitterStream twitterStream = new TwitterStreamFactory(configuration).getInstance();
        twitterStream.addListener(statusListener);
        twitterStream.user();
    }
}
