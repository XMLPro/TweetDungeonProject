package club.xmlpro.event;

import org.springframework.context.ApplicationEvent;

public class GoalEvent extends ApplicationEvent{
    public GoalEvent(Object source) {
        super(source);
    }
}
