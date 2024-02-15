import java.util.List;

public abstract class AbstractGame implements Game {
    protected String secretNumber;

    protected abstract void generateWord();
    protected abstract List<Character> generateCharList();
}
