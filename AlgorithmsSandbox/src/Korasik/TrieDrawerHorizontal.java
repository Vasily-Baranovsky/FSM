package Korasik;

import java.util.List;
import java.util.ArrayList;

public class TrieDrawerHorizontal implements ITrieDrawer {
    @Override
    public void draw(TrieNode trieNode) {

        // don't print root
        int level = trieNode.getLevel();
        if (level > 0) {
            List<TrieNode> lst = new ArrayList<>(trieNode.getParent().children.values());
            String childTabs =  (lst.indexOf(trieNode)>0) ? "-".repeat(level*2 - 1) : "-";
            System.out.print(childTabs + trieNode.getCharValue());
        }

        if (trieNode.children.size() == 0) {
            System.out.println();
        }

        for (TrieNode child : trieNode.children.values()) {
            child.draw();
        }
    }
}
