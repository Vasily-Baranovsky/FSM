package Korasik;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TrieNode {
    protected List<TrieNode> children= Collections.emptyList();
    protected String charValue;
    protected boolean endOfWord=false;

    public TrieNode(String value) {
        this.charValue = value;
    }

    public void addChild(String charValue) {
        if (children.stream().noneMatch(it -> it.charValue.equals(charValue))) {
            children.add(new TrieNode(charValue));
        }
    }

    public TrieNode findOrCreateChild(String charValue) {

        return children.stream().filter(it -> it.charValue.equals(charValue))
                .findFirst()
                .orElseGet(() -> {
                        TrieNode t = new TrieNode(charValue);
                        children.add(t);
                        return t;
                 });
    }

    public void addWord(String word) {
        for (int i=0; i<word.length(); ++i) {

        }
    }
}
