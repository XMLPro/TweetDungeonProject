package maze;

public class MazeGenerate {

	private int[][] map;// 0 or 1
	private Block[][] block;// WALL or ROAD クラスオブジェクト

	private int[] dx = {0, 1, 0, -1};
	private int[] dy = {1, 0, -1, 0};


	public void init(Player player, int side){
		if ( side%2 == 1){
			map = new int[side][side];
			player.setPlayer(side-2, side-2);
			makeMaze();
			setBlock(side);
		}else{
			System.out.println("奇数を入力してください");
		}
	}

	private void setBlock(int side){//引数はmapの方がいいか
		block = new Block[side][side];
		for (int i = 0 ; i < map.length ; i++){
			for (int j = 0 ; j < map[0].length ; j++){
				block[i][j] = new Block(map[i][j]);
			}
		}
	}
	public Block[][] getBlock(){
		return this.block;
	}

	public void setMap(int x, int y, int i){
		//mapの(x,y)座標に キャラクター or 床 or 壁 をセット
		map[x][y] = i;
	}
	public int[][] getMap(){
		return this.map;
	}

	//迷路生成
	private void makeMaze(){

		for (int i = 0 ; i < map.length ; i++){
			for (int j = 0 ; j < map[0].length ; j++){
				map[i][j] = 0;
			}
		}

		//外壁の生成
		for (int i = 0 ; i < map.length ; i++){
			map[0][i] = 1;
			map[map.length-1][i] = 1;
			map[i][0] = 1;
			map[i][map[0].length-1] = 1;
		}

		// 棒倒し法による支柱をセット
		for (int i = 1 ; i <= (map.length-2)/2 ; i++){
			for (int j = 1 ; j <= (map[0].length-2)/2 ; j++){
				map[i * 2][j * 2] = 1;
			}
		}

		/* 迷路作成 */
		for (int i = 1 ; i <= (map.length-2)/2 ; i++){
			for (int j = 1 ; j <= (map[0].length-2)/2 ; j++){
				if (i == 1){
					int d = (int)(Math.random() * 4);
					map[i * 2 + dx[d]][j * 2 + dy[d]] = 1;
				}else{
					boolean flag = true;
					while(flag){
						int d = (int)(Math.random() * 3);
						if (map[i * 2 + dx[d]][j * 2 + dy[d]] == 0){
							map[i * 2 + dx[d]][j * 2 + dy[d]] = 1;
							flag = false;
						}
					}
				}
			}
		}
	}
}
