package Korasik;

public class TrieDrawerByDefault implements ITrieDrawer {

    @Override
    public void draw(TrieNode trieNode) {
        //System.out.println(root.toString());

        String childTabs="-".repeat(trieNode.getLevel());
        System.out.println(childTabs+trieNode.getCharValue());

        for (TrieNode child : trieNode.children.values()) {
            child.draw();
        }
    }
}
