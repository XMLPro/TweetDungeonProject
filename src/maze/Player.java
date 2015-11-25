package maze;

public class Player {
	private int player_y = 1;//プレイヤーx座標
	private int player_x = 1;//プレイヤーy座標

	private PlayerMoveCommand movecommand;

	public void setPlayer(int x, int y){
		this.player_y = x;
		this.player_x = y;
	}

	public int getPlayerX(){
		return this.player_y;
	}

	public int getPlayerY(){
		return this.player_x;
	}

	//プレイヤー場所
	//移動先衝突判定
	public void Move(MazeGenerate maze, Block[][] block, PlayerMoveCommand movecommand){
		if(movecommand == PlayerMoveCommand.UP && block[this.player_y-1][this.player_x].isMovable()){ //上コマンドかつ移動先がWALLじゃない
			maze.setMap(this.player_y, this.player_x, 0);//移動元を0にする
			this.player_y-=1;
		}else if(movecommand == PlayerMoveCommand.DOWN && block[this.player_y+1][this.player_x].isMovable()){//
			maze.setMap(this.player_y, this.player_x, 0);//移動元を0にする
			this.player_y+=1;
		}else if(movecommand == PlayerMoveCommand.LEFT && block[this.player_y][this.player_x-1].isMovable()){//左
			maze.setMap(this.player_y, this.player_x, 0);//移動元を0にする
			this.player_x-=1;
		}else if(movecommand == PlayerMoveCommand.RIGHT && block[this.player_y][this.player_x+1].isMovable()){//右
			maze.setMap(this.player_y, this.player_x, 0);//移動元を0にする
			this.player_x+=1;
		}

	}



}
