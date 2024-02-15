public interface Game {
    void start();
    void inputValue(String input);
    GameStatus getGameStatus();
    void restart();
}
