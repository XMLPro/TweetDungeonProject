package maze;

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
			this.blockType = BlockType.PLAYER;
		}else if(blockType == 3){
			this.blockType = BlockType.START;
		}else if(blockType == 4){
			this.blockType = BlockType.GOAL;
		}
	}

	//移動可能判定
	public boolean isMovable(){
		if (this.blockType == BlockType.ROAD) {
			return true;
		}else if (this.blockType == BlockType.WALL) {
			return false;
		}else if (this.blockType == BlockType.PLAYER) {
			return false;
		}else if (this.blockType == BlockType.START) {
			return true;
		}else if (this.blockType == BlockType.GOAL) {
			return true;
		}
		return false;
	}
}
