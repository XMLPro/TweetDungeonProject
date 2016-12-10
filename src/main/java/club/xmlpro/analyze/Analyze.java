package club.xmlpro.analyze;

import club.xmlpro.dungeon.character.MoveCharacterDirection;
import club.xmlpro.event.AnalyzeEvent;
import club.xmlpro.event.MoveCharacterEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

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
        int analyzePointer = 0;
        //Twitter twitter = TwitterFactory.getSingleton();
        //twitter.updateStatus("aa");
        logger.info("ok");
        //String[] analyzeText = event.getTweet().split(" ");
        //logger.info(String.valueOf(analyzeText.length));
        String[] analyzeText = event.getTweet().split(" ");
        //logger.info(analyzeText[0]);
        if (analyzeText[0] == null){
            logger.info("null");
        }else switch (analyzeText[0]){
            //move event
            case "up":
                publisher.publishEvent(new MoveCharacterEvent(Analyze.class, MoveCharacterDirection.UP));
                break;

            case "down":
                publisher.publishEvent(new MoveCharacterEvent(Analyze.class, MoveCharacterDirection.DOWN));
                break;

            case "right":
                publisher.publishEvent(new MoveCharacterEvent(Analyze.class, MoveCharacterDirection.RIGHT));
                break;

            case "left":
                publisher.publishEvent(new MoveCharacterEvent(Analyze.class, MoveCharacterDirection.LEFT));

            default:
                break;
        }
    }
}
