package maze;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		MazeGenerate maze1 = new MazeGenerate();
		Player player1 = new Player();

		maze1.init(player1, 9);// 迷路初期化

		HashMap<Integer,PlayerMoveCommand> map = PlayerMoveCommand.getMap();
		Scanner scan = new Scanner(System.in);//(1なら上, 2なら下, 3なら左, 4なら右)

		for (int i = 0; i < 25; i++) {

			player1.Move(maze1, maze1.getBlock(), map.get(scan.nextInt()));
			maze1.setMap(player1.getPlayerX(), player1.getPlayerY(), 2);
			int[][] a = maze1.getMap();

			for (int j = 0; j < a.length; j++){
				for (int k = 0; k < a.length; k++){
					System.out.print(a[j][k]);
				}
				System.out.println();
			}

		 }

	}
}
