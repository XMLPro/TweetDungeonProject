package club.xmlpro.twitter;



import club.xmlpro.event.AnalyzeEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;



@Component
public class TwitterStreamStartUp {
    private final String CONSUMER_KEY = "MoZJ2HZGMQBN3NYMfMetW8dxm";
    private final String CONSUMER_KEY_SECRET = "Ye7SFLvSJzeKyT71Reb8MKkpsPkmjwhceOGodIjrtOEa3pRQZ6";
    private final String ACCESS_TOKEN = "805630906572472321-JurEMFFoYFFAOj8GeGhB59vLz0BhJmT";
    private final String ACCESS_TOKEN_SECRET = "8d3qU0ANImr6I0u3YnuSIRhBPwjFimiwKtqiOiuU98Cun";

    @Autowired
    ApplicationEventPublisher publisher;

    @EventListener
    public void test(ApplicationReadyEvent event){
        publisher.publishEvent(new AnalyzeEvent(this));
    }

    /*

    public void start(ApplicationReadyEvent event) {
        Configuration configuration = new ConfigurationBuilder()
                .setOAuthConsumerKey(CONSUMER_KEY)
                .setOAuthConsumerSecret(CONSUMER_KEY_SECRET)
                .setOAuthAccessToken(ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET)
                .build();


        new TwitterFactory(configuration);

        TwitterStream twitterStream = new TwitterStreamFactory(configuration).getInstance();
        twitterStream.addListener(new TwitterListener());
        twitterStream.user();
    }
    */
}
