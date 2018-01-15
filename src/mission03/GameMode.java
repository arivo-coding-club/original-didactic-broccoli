package mission03;

/**
 * Created by newt.on on 2018. 1. 12..
 */
public abstract class GameMode {
    private Tool tool;

    public GameMode(Tool tool) {
        this.tool = tool;
    }

    protected abstract Player getFirstPlayer();
    protected abstract Player getSecondPlayer();

    public void start() {
        Player first = getFirstPlayer();
        Player second = getSecondPlayer();

        Game game = new Game(tool, first, second);
        game.start();
    }

    protected Tool getTool() {
        return tool;
    }
}
