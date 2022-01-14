package BrutStringSearch;

public class Hypothesis {
    private final String dictionaryString;
    private final int startIndex;
    private int numberOfCheckedSymbols;
    public enum HypothesisState {
            TRUE,
            FALSE,
            IN_PROGRESS
    }

    public Hypothesis(String dictionaryString, int startIndex, int numberOfCheckedSymbols) {
        this.dictionaryString = dictionaryString;
        this.startIndex = startIndex;
        this.numberOfCheckedSymbols = numberOfCheckedSymbols;
    }

    public HypothesisState checkHypothesisState(char currentChar) {
        if(currentChar == dictionaryString.charAt(numberOfCheckedSymbols)) {
            numberOfCheckedSymbols++;
            if (numberOfCheckedSymbols == dictionaryString.length()) {
                return HypothesisState.TRUE;
            } else {
                return HypothesisState.IN_PROGRESS;
            }
        } else {
            return HypothesisState.FALSE;
        }
    }

    public int getStartIndex() {
        return startIndex;
    }

    public String getDictionaryString() {
        return dictionaryString;
    }
}
