package club.xmlpro.dungeon.maze.block;

import club.xmlpro.dungeon.maze.BlockType;
import club.xmlpro.dungeon.maze.block.blocks.GoalBlock;
import club.xmlpro.dungeon.maze.block.blocks.RoadBlock;
import club.xmlpro.dungeon.maze.block.blocks.StartBlock;
import club.xmlpro.dungeon.maze.block.blocks.WallBlock;

public class BlockFactory {
    public Block getInstance(BlockType blockType){
        switch (blockType){
            case START:
                return new StartBlock();
            case GOAL:
                return new GoalBlock();
            case ROAD:
                return new RoadBlock();
            case WALL:
                return new WallBlock();
            default:
                return null;
        }
    }
}
