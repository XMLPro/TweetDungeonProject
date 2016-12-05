package club.xmlpro.models;

public class MazeFactory {
    public int[][] getMaze(){
        MazeGenerate mazeGenerate = new MazeGenerate();
        return mazeGenerate.getDungeonMap();
    }
}
