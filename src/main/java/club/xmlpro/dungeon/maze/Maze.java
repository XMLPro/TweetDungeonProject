package club.xmlpro.dungeon.maze;

import club.xmlpro.dungeon.maze.block.Block;
import club.xmlpro.dungeon.maze.block.blocks.GoalBlock;

public class Maze implements MazeImp{
    private int[][] map;
    private Block[][] mapBlock;

    public void init(int x, int y, int startX, int startY){
        GenerateMaze generateMaze = new GenerateMaze();
        generateMaze.generate(x, y, startX, startY);
        map = generateMaze.getMap();
        mapBlock = generateMaze.getMapBlock();
    }

    public boolean canMove(int x, int y){
        return mapBlock[x][y].isThrow();
    }

    public boolean isGoal(int x, int y){
        if (mapBlock[x][y] instanceof GoalBlock) return true;
        else return false;
    }

    @Override
    public int[][] getMap() {
        return map;
    }

    @Override
    public Block[][] getMapBlock() {
        return mapBlock;
    }
}
