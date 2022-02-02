package BrutStringSearch;

import Korasik.TrieNode;

public class TrieHypothesis {
    private TrieNode foundNode;
    private int startIndex;
    public enum HypothesisState {
        TRUE,
        FALSE,
        IN_PROGRESS
    }

    public TrieHypothesis(int startIndex, TrieNode foundNode) {
        this.startIndex = startIndex;
        this.foundNode = foundNode;
    }

    public HypothesisState checkTrieHypothesisState(char currentChar) {
        if (currentChar ==
                //TODO continue here with trieNodeHypothesis
    }

}
