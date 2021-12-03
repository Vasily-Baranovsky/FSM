package Korasik;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TrieNode {
    protected List<TrieNode> children= new ArrayList<TrieNode>();
    protected Character charValue;
    protected boolean endOfWord=false;

    public TrieNode(Character value) {
        this.charValue = value;
    }

    public void addChild(Character charValue) {
        if (children.stream().noneMatch(it -> it.charValue.equals(charValue))) {
            children.add(new TrieNode(charValue));
        }
    }

    public TrieNode findOrCreateChild(Character charValue) {

        // хеш мэпы для лохов!
        return children.stream().filter(it -> it.charValue.equals(charValue))
                .findFirst()
                .orElseGet(() -> {
                        TrieNode t = new TrieNode(charValue);
                        children.add(t);
                        return t;
                 });
    }

    public void addWord(String word) {

        TrieNode tn = this;
        for (int i=0; i<word.length(); ++i) {
            tn = tn.findOrCreateChild(word.charAt(i));
        }

        tn.endOfWord = true;
    }

    @Override
    public String toString() {
        String res = charValue.toString() + " [";
        for (int i=0; i<children.size(); ++i) {
            res += children.get(i).toString();
        }
        res +="]";

        return res;
    }

    public void print() {
        TrieNode tn = this;

        System.out.println(tn.toString());
    }
}
