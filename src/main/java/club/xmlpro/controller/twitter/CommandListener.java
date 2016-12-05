package club.xmlpro.controller.twitter;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import twitter4j.*;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

@Service
public class CommandListener {
    @Async
    public void getStream(){
        StatusListener listener = new StatusListener() {
            @Override
            public void onStatus(Status status) {
                System.out.println();
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
        };

        Configuration configuration = new ConfigurationBuilder()
                .setOAuthConsumerKey("MoZJ2HZGMQBN3NYMfMetW8dxm")
                .setOAuthConsumerSecret("Ye7SFLvSJzeKyT71Reb8MKkpsPkmjwhceOGodIjrtOEa3pRQZ6")
                .setOAuthAccessToken("805630906572472321-JurEMFFoYFFAOj8GeGhB59vLz0BhJmT")
                .setOAuthAccessTokenSecret("805630906572472321-JurEMFFoYFFAOj8GeGhB59vLz0BhJmT")
                .build();
        TwitterStream twitterStream = new TwitterStreamFactory(configuration).getInstance();
        twitterStream.addListener(listener);

        twitterStream.sample();
    }
}
