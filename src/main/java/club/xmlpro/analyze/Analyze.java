package club.xmlpro.analyze;

import club.xmlpro.config.TwitterConfig;
import club.xmlpro.dungeon.DirectionType;
import club.xmlpro.event.AnalyzeEvent;
import club.xmlpro.event.MoveCharacterEvent;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import twitter4j.TwitterException;

//The singleton class method

@Component
public class Analyze {
    //first version,
    //tweet analyzed all delete event
    private static final Logger logger = LoggerFactory.getLogger(Analyze.class);

    @Autowired
    private ApplicationEventPublisher publisher;

    @EventListener
    public void analyze(AnalyzeEvent event) throws TwitterException {
        logger.info("start analyze");
        logger.info(event.getTweet());
        int analyzePointer = 0;
        String tweet = event.getTweet().replace(TwitterConfig.TWITTER_ACCOUNT, "");
        String[] analyzeText = tweet.split(" ");
        logger.info(analyzeText[0]);
        logger.info(analyzeText[1]);
        if (analyzeText[1] == null){
            logger.info("null");
        }else switch (analyzeText[1]){
            //move event
            case "up":
                publisher.publishEvent(new MoveCharacterEvent(Analyze.class, DirectionType.UP));
                break;

            case "down":
                publisher.publishEvent(new MoveCharacterEvent(Analyze.class, DirectionType.DOWN));
                break;

            case "right":
                publisher.publishEvent(new MoveCharacterEvent(Analyze.class, DirectionType.RIGHT));
                break;

            case "left":
                publisher.publishEvent(new MoveCharacterEvent(Analyze.class, DirectionType.LEFT));

            default:
                break;
        }

    }
}
