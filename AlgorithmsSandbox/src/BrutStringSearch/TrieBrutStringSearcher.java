package BrutStringSearch;

import Korasik.TrieDrawerHorizontal;
import Korasik.TrieNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrieBrutStringSearcher implements SubstringSearcher{
    private TrieNode trie = new TrieNode(new TrieDrawerHorizontal());

    public TrieBrutStringSearcher(String[] dictionary) {
        for (String s:dictionary) {
            addToDictionary(s);
        }
    }

    @Override
    public void addToDictionary(String s) {
        trie.addWord(s);
    }

    @Override
    public HashMap<String, List<Integer>> searchString(String s) {
        HashMap<String, List<Integer>> resultSubstringMap = new HashMap<>();
        ArrayList<TrieNode> hypothesysNodes = new ArrayList<>();
        StringBuilder foundString = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (trie.findChild(s.charAt(i)) != null) {
                hypothesysNodes.add(trie.findChild(s.charAt(i)));
                foundString.append(s.charAt(i));
            }
            for (int j = 0; j < hypothesysNodes.size();) {
                TrieNode hypNode = hypothesysNodes.get(j);
                if (hypNode.findChild(s.charAt(i)) != null) {
                    if (hypNode.getChildren().isEmpty()) {
                        hypothesysNodes.remove(j);
                    }
                }
            }
        }
        return resultSubstringMap;
    }
}
