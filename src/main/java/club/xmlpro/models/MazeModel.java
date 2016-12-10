package club.xmlpro.dungeon.maze;

public class MazeModel {
    int[][] map;
    public MazeModel(int[][] map){
        this.map = map;
    }

    public int[][] getMap() {
        return map;
    }
}
