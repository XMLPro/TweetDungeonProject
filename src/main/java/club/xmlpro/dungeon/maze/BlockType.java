package club.xmlpro.dungeon.maze;

public enum BlockType {
    START(0),
    GOAL(1),
    ROAD(2),
    WALL(3);


    private final int blockNumber;
    BlockType(int blockNumber){
        this.blockNumber = blockNumber;
    }

    public int getBlockNumber(){
        return blockNumber;
    }
}
