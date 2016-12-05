package club.xmlpro.models;

public class Maze implements MazeImp {
    private int[][] dungeonMap;
    private Block[][] dungeonMapBlock;
    private int[][] characterPoint;

    public Maze(){
        dungeonMap = new MazeFactory().getMaze();
    }

    public void initMaze(){
        dungeonMap = new MazeFactory().getMaze();
    }

    @Override
    public int[][] getDungeonMap() {
        return dungeonMap;
    }

    @Override
    public Block[][] getDungeonMapBlock() {
        return dungeonMapBlock;
    }


}
