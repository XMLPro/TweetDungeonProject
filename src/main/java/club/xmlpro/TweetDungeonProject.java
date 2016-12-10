package club.xmlpro;

import club.xmlpro.event.AnalyzeEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class TweetDungeonProject {
	public static void main(String[] args) {
		SpringApplication.run(TweetDungeonProject.class, args);
	}
}