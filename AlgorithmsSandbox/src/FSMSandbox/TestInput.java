package FSMSandbox;

public class TestInput {
    String inputString;
    boolean isCorrect;
    double value;

    public static TestInput getTestInput() {
        return new TestInput("1 ", true, 1.0);
    }

    private TestInput(String inputString, boolean isCorrect, double value) {
        this.inputString = inputString;
        this.isCorrect = isCorrect;
        this.value = value;
    }

}
