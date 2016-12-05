package club.xmlpro.models;

public class Dungeon implements DungeonImp {
    @Override
    public int[][] getDungeonMap() {
        return new int[0][];
    }

    @Override
    public Block[][] getDungeonMapBlock() {
        return new Block[0][];
    }

    @Override
    public int[] CharacterPoint() {
        return new int[0];
    }
}
