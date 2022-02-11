package Korasik;

import java.util.ArrayList;
import java.util.List;

public class AkhoKorasikAutomaton {

    private TrieNode currentNode;

    public AkhoKorasikAutomaton(TrieNode root) {
        this.currentNode = root;
    }

    public List<String> handleSymbol(Character character) throws GettingWordFromNonEndNodeException {
        TrieNode foundChild = currentNode.findChild(character);
        List<String> resultStrings = new ArrayList<>();

        while (foundChild == null && currentNode.getSuffixLink() != null) {
            currentNode = currentNode.getSuffixLink();
            foundChild = currentNode.findChild(character);
        }

        if (foundChild != null) {
            // если нашли то идем вперед, а потом проверяем, конец это слова или нет и есть ли финальные ссылки
            if (foundChild.endOfWord) {
                 resultStrings.add(foundChild.getWord());
            }
            TrieNode outputNode = foundChild;
            while (outputNode.getOutputLink() != null) {
                outputNode = outputNode.getOutputLink();
                resultStrings.add(outputNode.getWord());
            }
            currentNode = foundChild;
        }

        return resultStrings;

    }

}
