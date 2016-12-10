package club.xmlpro.dungeon;

import club.xmlpro.config.MazeDefaultConfig;
import club.xmlpro.dungeon.character.Character;
import club.xmlpro.dungeon.maze.Maze;
import club.xmlpro.models.MazeModel;
import club.xmlpro.event.GoalEvent;
import club.xmlpro.event.MoveCharacterEvent;
import club.xmlpro.models.CharacterModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;


@Controller
public class Dungeon implements DungeonImp{
    private static final Logger logger = LoggerFactory.getLogger(Dungeon.class);
    private Character character;
    private Maze maze;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    ApplicationEventPublisher publisher;

    private void init(int x, int y, int startX, int startY) {
        maze = new Maze();
        maze.init(x,y,startX,startY);
        character = new Character(startX,startY);
    }

    @EventListener
    public void startDungeon(ApplicationReadyEvent event){
        init(MazeDefaultConfig.DUNGEON_MAP_WIDTH, MazeDefaultConfig.DUNGEON_MAP_HEIGHT, MazeDefaultConfig.CHARACTER_START_X, MazeDefaultConfig.CHARACTER_START_Y);
        logger.info("create map");
    }

    @EventListener
    public void goalEvent(GoalEvent event){
        init(MazeDefaultConfig.DUNGEON_MAP_WIDTH, MazeDefaultConfig.DUNGEON_MAP_HEIGHT, MazeDefaultConfig.CHARACTER_START_X, MazeDefaultConfig.CHARACTER_START_Y);
    }

    @EventListener
    public void moveCharacter(MoveCharacterEvent event){
        logger.info("moving");
        switch (event.getDirectionType()){
            case UP:
                if (maze.canMove(character.getPointX(), character.getPointY()-1)){
                    setCharacterPoints(character.getPointX(), character.getPointY()-1);
                }
                break;
            case DOWN:
                if (maze.canMove(character.getPointX(), character.getPointY()+1)){
                    setCharacterPoints(character.getPointX(), character.getPointY()+1);
                }
                break;
            case RIGHT:
                if (maze.canMove(character.getPointX()+1, character.getPointY())){
                    setCharacterPoints(character.getPointX()+1, character.getPointY());
                }
                break;
            case LEFT:
                if (maze.canMove(character.getPointX()-1, character.getPointY())){
                    setCharacterPoints(character.getPointX()-1, character.getPointY());
                }
                break;
        }
        if (maze.isGoal(character.getPointX(), character.getPointY())) publisher.publishEvent(new GoalEvent(this));
        simpMessagingTemplate.convertAndSend("/topic/character", new CharacterModel(character.getPointX(), character.getPointY()));
        //return new CharacterModel(character.getPointX(), character.getPointY());
    }

    private void setCharacterPoints(int x, int y){
        logger.info("ok");
        character.moveX(x);
        character.moveY(y);
    }


    @MessageMapping("/map")
    public void getaaze(){
        simpMessagingTemplate.convertAndSend("/topic/map" , new MazeModel(maze.getMap()));
    }
}
