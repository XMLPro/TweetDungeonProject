package club.xmlpro.event;

import org.springframework.context.ApplicationEvent;

public class AnalyzeEvent extends ApplicationEvent {
    private String tweet;
    public AnalyzeEvent(Object source, String tweet) {
        super(source);
        this.tweet = tweet;
    }

    public String getTweet() {
        return tweet;
    }
}
