import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NumberGame extends AbstractGame {
    private static final Logger logger = LogManager.getLogger(NumberGame.class);

    // Другие методы игры

    @Override
    public void inputValue(String input) {
        // Логирование ввода
        logger.info("Игрок ввел: " + input);

        // Логика проверки и обработки ввода

        // Пример логирования ответа
        logger.info("Ввод: " + input + " - " + new Answer(bulls, cows));
    }
}

import java.util.ArrayList;
import java.util.List;

public class NumberGame extends AbstractGame {
    private List<String> gameHistory;

    public NumberGame() {
        gameHistory = new ArrayList<>();
    }

    public List<String> getGameHistory() {
        return gameHistory;
    }
}

public void restart() {
    generateWord();
    gameHistory.clear(); // Очистка истории
    logger.info("Игра перезапущена. Новое число/слово задумано.");
}



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

        
    }
}
