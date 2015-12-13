package models;

import java.util.HashMap;
import java.util.Map;

public enum PlayerMoveCommand {
	UP(1),
	DOWN(2),
	LEFT(3),
	RIGHT(4);

	private final int id;

	private PlayerMoveCommand(final int id){
		this.id = id;
	}

	public int getId(){
		return this.id;
	}

	public static HashMap getMap(){
		HashMap<Integer,PlayerMoveCommand> map = new HashMap<>();
		map.put(1, PlayerMoveCommand.UP);
		map.put(2, PlayerMoveCommand.DOWN);
		map.put(3, PlayerMoveCommand.LEFT);
		map.put(4, PlayerMoveCommand.RIGHT);

		return map;
	}
}

