package mission03;

/**
 * Created by newt.on on 2018. 1. 12..
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
        // 문제? 이렇게 해도 문제가 없을지?
        return player == other.player;
    }
}
