package club.xmlpro.dungeon;

import club.xmlpro.dungeon.character.Character;
import club.xmlpro.dungeon.maze.Maze;
import club.xmlpro.event.MoveCharacterEvent;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
@Component
public class Dungeon implements DungeonImp{
    private Character character;
    private Maze maze;

    @Override
    public void init() {
        maze = new Maze();
        character = new Character(1,1);
    }


    @EventListener
    @SendTo("/topic/character")
    public Character MoveCharacter(MoveCharacterEvent event){
        return character;
        /*switch (event.direction()){
            case UP:
                character.moveY(character.getPointY()+1);
                return this.character;
            default:
                return null;

        }*/
    }


}
