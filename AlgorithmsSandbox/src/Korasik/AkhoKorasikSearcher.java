package Korasik;

import BrutStringSearch.SubstringSearcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AkhoKorasikSearcher implements SubstringSearcher {


    private TrieNode trie = new TrieNode();
    public boolean suffixLinksCreated = false;

    public AkhoKorasikSearcher(String[] strings) {
        for (String s: strings) {
            addToDictionary(s);
        }
    }

    @Override
    public void addToDictionary(String s) {
        suffixLinksCreated = false;
        trie.addWord(s);
    }

    @Override
    public HashMap<String, List<Integer>> searchString(String s) {
        trie.buildSuffixLinks();
        suffixLinksCreated = true;
        HashMap<String, List<Integer>> result = new HashMap<>();

        AkhoKorasikAutomaton automaton = new AkhoKorasikAutomaton(trie);

        for (int i = 0; i < s.length(); i++) {
            try {
                List<String> searchResult = automaton.handleSymbol(s.charAt(i));
                for (String word: searchResult) {
                    List<Integer> indexies = result.computeIfAbsent(word, a -> new ArrayList<>());
                    indexies.add(i-word.length()+1);
                }
            } catch (GettingWordFromNonEndNodeException exception) {
                throw new RuntimeException("You are trying to get word from non end element");
            }
        }

        return result;
    }
}
