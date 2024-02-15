import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGame extends AbstractGame {
    public NumberGame() {
        generateWord();
    }

    @Override
    protected void generateWord() {
        List<Character> charList = generateCharList();
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) { // Для примера, будем использовать число из четырех цифр
            sb.append(charList.get(random.nextInt(charList.size())));
        }
        secretNumber = sb.toString();
    }

    @Override
    protected List<Character> generateCharList() {
        List<Character> charList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            charList.add((char) (i + '0'));
        }
        return charList;
    }

    @Override
    public void start() {
        System.out.println("Игра началась. Угадайте 4-значное число, задуманное компьютером.");
    }

    @Override
    public void inputValue(String input) {
        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == secretNumber.charAt(i)) {
                bulls++;
            } else if (secretNumber.contains(String.valueOf(input.charAt(i))) && input.charAt(i) != secretNumber.charAt(i)) {
                cows++;
            }
        }

        System.out.println("Ввод: " + input + " - " + new Answer(bulls, cows));

        if (bulls == 4) {
            System.out.println("Вы угадали число! Поздравляем!");
        }
    }

    @Override
    public GameStatus getGameStatus() {
        return GameStatus.IN_PROGRESS;
    }

    @Override
    public void restart() {
        generateWord();
        System.out.println("Новое число задумано. Начнем заново.");
    }

    public static void main(String[] args) {
        NumberGame numberGame = new NumberGame();
        numberGame.start();

        // Здесь можно добавить цикл for для управления ходами игры
    }
}
