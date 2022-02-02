package BrutStringSearch;

import Korasik.GettingWordFromNonEndNodeException;
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
        ArrayList<TrieHypothesis> hypothesyss = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);


            TrieHypothesis newHypothesis = TrieHypothesis.checkAndCreate(trie, currentChar, i);
            if (newHypothesis != null) {
                hypothesyss.add(newHypothesis);
            }


            int j = 0;
            while (j < hypothesyss.size()) {
                TrieHypothesis currentHypothesis = hypothesyss.get(j);
                switch (currentHypothesis.checkTrieHypothesisState(currentChar)) {
                    case TRUE:
                        try {
                            List<Integer> foundIndexes = resultSubstringMap.computeIfAbsent(currentHypothesis.getWord(),
                                    k -> new ArrayList<>()
                            );
                            foundIndexes.add(currentHypothesis.getStartIndex());
                        } catch (GettingWordFromNonEndNodeException e) {
                            throw new RuntimeException("Все пошло по BNS");
                        }
                    case IN_PROGRESS:
                        j++;
                        break;

                    case FALSE:
                        hypothesyss.remove(j);
                }

            }
        }
        return resultSubstringMap;
    }
}
