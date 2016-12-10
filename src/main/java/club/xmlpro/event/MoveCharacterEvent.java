package club.xmlpro.event;

import club.xmlpro.dungeon.character.MoveCharacterDirection;
import org.springframework.context.ApplicationEvent;

public class MoveCharacterEvent extends ApplicationEvent {
    private MoveCharacterDirection moveCharacterDirection;
    public MoveCharacterEvent(Object source, MoveCharacterDirection moveCharacterDirection) {
        super(source);
        this.moveCharacterDirection = moveCharacterDirection;
    }

    public MoveCharacterDirection direction(){
        return moveCharacterDirection;
    }
}
