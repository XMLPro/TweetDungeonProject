package club.xmlpro.dungeon.maze;

import club.xmlpro.dungeon.maze.block.Block;

public class Maze implements MazeImp{
    private int[][] map;
    private Block[][] mapBlock;
    private int startX;
    private int startY;

    public void init(int x, int y, int startX, int startY){
        GenerateMaze generateMaze = new GenerateMaze();
        generateMaze.generate(x, y, startX, startY);
        map = generateMaze.getMap();
        mapBlock = generateMaze.getMapBlock();
    }

    public boolean canMove(int x, int y){
        return mapBlock[x][y].isThrow();
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
