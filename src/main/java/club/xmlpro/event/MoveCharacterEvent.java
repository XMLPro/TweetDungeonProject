package club.xmlpro.event;

import club.xmlpro.dungeon.DirectionType;
import org.springframework.context.ApplicationEvent;

public class MoveCharacterEvent extends ApplicationEvent {
    private DirectionType directionType;
    public MoveCharacterEvent(Object source, DirectionType directionType) {
        super(source);
        this.directionType = directionType;
    }

    public DirectionType getDirectionType() {
        return directionType;
    }
}
