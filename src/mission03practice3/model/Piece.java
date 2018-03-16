package mission03practice3.model;

import mission03practice3.game.Player;

/**
 * Created by newt.on on 2018. 1. 11..
 */

public class Piece {
	private final Player player;
	
	private final Position position;
	
	public Piece(Player player, Position position) {
		this.player = player;
		this.position = position;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public boolean equalPlayer(Piece other) {
		return player == other.player;
	}
}

