package club.xmlpro.dungeon.maze;

import club.xmlpro.dungeon.maze.block.BlockType;

public class Test {
    public static void main(String[] args) {
        GenerateMaze maze =new GenerateMaze();
        maze.generate(13, 19, 4,6);
        int[][] map = maze.getMap();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == BlockType.WALL.getBlockNumber()) {
                    System.out.print("■");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
