package club.xmlpro.models;

public class Block {
    private BlockType blockType;

    public Block(BlockType blockType) {
        this.blockType = blockType;
    }

    public Block(int blockType){
        if (blockType == 0) {
            this.blockType = BlockType.ROAD;
        }else if(blockType == 1){
            this.blockType = BlockType.WALL;
        }else if(blockType == 2){
            //this.blockType = BlockType.PLAYER;
        }else if(blockType == 3){
            this.blockType = BlockType.START;
        }else if(blockType == 4){
            this.blockType = BlockType.GOAL;
        }
    }

    //移動可能判定
    public boolean isMovable(){
        switch (blockType){
            case ROAD:
                return true;
            case WALL:
                return false;
            case START:
                return true;
            case GOAL:
                return true;
            default:
                return false;
        }
    }
}
