package club.xmlpro.dungeon.maze;

import club.xmlpro.dungeon.maze.block.Block;
import club.xmlpro.dungeon.maze.block.BlockFactory;
import club.xmlpro.dungeon.maze.block.BlockType;

import java.util.ArrayList;
import java.util.Collections;

    /*
        x 0 1 2 .. n
       y
       0
       1
       2
       .
       .
       n

     */
public class GenerateMaze implements MazeImp{
    private BlockType[][] blockTypeMap;
    private int[][] map;
    private Block[][] blockMap;

    private int startX;
    private int startY;
    private int goalX;
    private int goalY;

    public void generate(int x, int y, int startX, int startY){
        blockTypeMap = new BlockType[x][y];
        map = new int[x][y];
        blockMap = new Block[x][y];
        this.startX = startX;
        this.startY = startY;
        baseInit();
        digMap(startX, startY);
        generateMap();
        generateBlockMap();
        detectGoal();
        setStartAndGoal();
    }

    private ArrayList<DirectionList> getRandomDirection(){
        ArrayList<DirectionList> direction = new ArrayList<>();
        direction.add(DirectionList.UP);
        direction.add(DirectionList.DOWN);
        direction.add(DirectionList.RIGHT);
        direction.add(DirectionList.LEFT);
        Collections.shuffle(direction);
        return direction;
    }

    private void baseInit(){
        for (int i = 0; i < blockTypeMap.length; i++){
            for (int j = 0; j < blockTypeMap[i].length; j++){
                blockTypeMap[i][j] = BlockType.WALL;
            }
        }
    }

    private void digMap(int x, int y){
        blockTypeMap[x][y] = BlockType.ROAD;
        ArrayList<DirectionList> direction = getRandomDirection();
        for (int i = 0; i < direction.size(); i++){
            switch (direction.get(i)) {
                case UP:
                    if (y + 2 < blockTypeMap[x].length-1) {
                        if (blockTypeMap[x][y+2] == BlockType.WALL) {
                            blockTypeMap[x][y+1] = BlockType.ROAD;
                            digMap(x, y+2);
                        }
                    }
                    break;
                case DOWN:
                    if (y-2 > 0) {
                        if (blockTypeMap[x][y - 2] == BlockType.WALL) {
                            blockTypeMap[x][y - 1] = BlockType.ROAD;
                            digMap(x, y - 2);
                        }
                    }
                    break;
                case RIGHT:
                    if (x+2 < blockTypeMap.length - 1) {
                        if (blockTypeMap[x + 2][y] == BlockType.WALL) {
                            blockTypeMap[x + 1][y] = BlockType.ROAD;
                            digMap(x + 2, y);
                        }
                    }
                    break;
                case LEFT:
                    if (x-2 > 0) {
                        if (blockTypeMap[x - 2][y] == BlockType.WALL) {
                            blockTypeMap[x - 1][y] = BlockType.ROAD;
                            digMap(x - 2, y);
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private void generateMap(){
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                map[i][j] = blockTypeMap[i][j].getBlockNumber();
            }
        }
    }

    private void detectGoal(){
        for (int i = blockTypeMap.length-1; i > 0; i--){
            for (int j = blockTypeMap[i].length-1; j > 0; j--){
                if (map[i][j] == BlockType.ROAD.getBlockNumber()){
                    goalX = i;
                    goalY = j;
                    return;
                }
            }
        }
    }

    private void generateBlockMap(){
        BlockFactory blockFactory = new BlockFactory();
        for (int i = 0; i < blockMap.length; i++){
            for (int j = 0; j < blockMap[i].length; j++){
                 blockMap[i][j] = blockFactory.getInstance(blockTypeMap[i][j]);
            }
        }
    }

    private void setStartAndGoal(){
        BlockFactory blockFactory = new BlockFactory();
        //start
        map[startX][startY] = BlockType.START.getBlockNumber();
        blockMap[startX][startY] =  blockFactory.getInstance(BlockType.START);
        //goal
        map[goalX][goalY] = BlockType.GOAL.getBlockNumber();
        blockMap[goalX][goalY] =  blockFactory.getInstance(BlockType.GOAL);
    }

    @Override
    public int[][] getMap() {
        return map;
    }

    @Override
    public Block[][] getMapBlock() {
        return blockMap;
    }
}