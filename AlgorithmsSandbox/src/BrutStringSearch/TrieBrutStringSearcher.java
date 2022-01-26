package BrutStringSearch;

import Korasik.TrieDrawerHorizontal;
import Korasik.TrieNode;

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

        for (int i = 0; i < s.length(); i++) {
//            trie.
        }
        return resultSubstringMap;
    }
}
