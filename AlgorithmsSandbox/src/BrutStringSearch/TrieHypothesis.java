package BrutStringSearch;

import Korasik.GettingWordFromNonEndNodeException;
import Korasik.TrieNode;

public class TrieHypothesis {
    private TrieNode foundNode;

    private int startIndex;

    public int getStartIndex() {
        return startIndex;
    }

    public String getWord() throws GettingWordFromNonEndNodeException {
        if (!foundNode.isEndOfWord()) {
            throw new GettingWordFromNonEndNodeException();
        }
        return foundNode.getWord();
    }

    public enum HypothesisState {
        TRUE,
        FALSE,
        IN_PROGRESS
    }

    public static TrieHypothesis checkAndCreate (TrieNode trie, char currentSymbol, int currentIndex) {
        TrieNode currentNode = trie.findChild(currentSymbol);

        if (currentNode == null) {
            return null;
        }

        return new TrieHypothesis(currentIndex, currentNode);
    }

    public TrieHypothesis(int startIndex, TrieNode foundNode) {
        this.startIndex = startIndex;
        this.foundNode = foundNode;
    }

    public HypothesisState updateAndReturnTrieHypothesisState(char currentChar) {
        TrieNode nextNode = foundNode.findChild(currentChar);
        if (nextNode == null) {
            return HypothesisState.FALSE;
        }
        foundNode = nextNode;

        return checkHypothesisState();
    }

    public HypothesisState checkHypothesisState() {
        return foundNode.isEndOfWord() ? HypothesisState.TRUE : HypothesisState.IN_PROGRESS;
    }

}
