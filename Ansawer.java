public class Answer {
    private int bulls;
    private int cows;

    public Answer(int bulls, int cows) {
        this.bulls = bulls;
        this.cows = cows;
    }

    @Override
    public String toString() {
        return bulls + " бык(ов) " + cows + " коров(ы)";
    }
}
