package maze;

public class Player {
	private int player_y = 1;// プレイヤーx座標
	private int player_x = 1;// プレイヤーy座標

	private PlayerMoveCommand movecommand;

	public void setPlayer(int x, int y) {
		this.player_y = x;
		this.player_x = y;
	}

	public int getPlayerX() {
		return this.player_y;
	}

	public int getPlayerY() {
		return this.player_x;
	}

	// 移動(ゴールでtrueを, それ以外でfalseを返す)
	public boolean Move(MazeGenerate maze, PlayerMoveCommand movecommand) {
		if (movecommand == PlayerMoveCommand.UP && maze.getPointBlock(this.player_y - 1, this.player_x).isMovable()) {
			// 上コマンド
			maze.setMap(this.player_y, this.player_x, 0);// 移動元を0にする
			this.player_y -= 1;
			if (maze.getPointMap(this.player_y, this.player_x) == 4) {// 移動先マスがゴールの場合
				return true;
			}
			return false;
		} else if (movecommand == PlayerMoveCommand.DOWN
				&& maze.getPointBlock(this.player_y + 1, this.player_x).isMovable()) {
			// 下コマンド
			maze.setMap(this.player_y, this.player_x, 0);// 移動元を0にする
			this.player_y += 1;
			if (maze.getPointMap(this.player_y, this.player_x) == 4) {// 移動先マスがゴールの場合
				return true;
			}
			return false;
		} else if (movecommand == PlayerMoveCommand.LEFT
				&& maze.getPointBlock(this.player_y, this.player_x - 1).isMovable()) {
			// 左コマンド
			maze.setMap(this.player_y, this.player_x, 0);// 移動元を0にする
			this.player_x -= 1;
			if (maze.getPointMap(this.player_y, this.player_x) == 4) {// 移動先マスがゴールの場合
				return true;
			}
			return false;
		} else if (movecommand == PlayerMoveCommand.RIGHT
				&& maze.getPointBlock(this.player_y, this.player_x + 1).isMovable()) {
			// 右コマンド
			maze.setMap(this.player_y, this.player_x, 0);// 移動元を0にする
			this.player_x += 1;
			if (maze.getPointMap(this.player_y, this.player_x) == 4) {// 移動先マスがゴールの場合
				return true;
			}
			return false;
		}
		return false;

	}

}
