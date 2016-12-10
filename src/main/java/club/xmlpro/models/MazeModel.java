package club.xmlpro.models;

public class MazeModel {
    int[][] map;
    public MazeModel(int[][] map){
        this.map = map;
    }

    public int[][] getMap() {
        return map;
    }
}
