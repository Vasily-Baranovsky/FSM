package Korasik;

import java.util.ArrayList;
import java.util.List;

public class TrieNode {
    private final Character EMPTY_CHAR_VALUE='.';
    protected List<TrieNode> children= new ArrayList<TrieNode>();



    private Character charValue;
    public Character getCharValue() {
        return charValue;
    }

    protected boolean endOfWord=false;


    private ITrieDrawer drawer = new TrieDrawerByDefault(); // only for printing of the trie

    private int level=0;                  // only for printing of the trie
    public int getLevel() {
        return level;
    }

    private TrieNode parent = null;       // only for printing of the trie
    public TrieNode getParent() {
        return parent;
    }

    public TrieNode(ITrieDrawer drawer) {
        this.charValue = EMPTY_CHAR_VALUE;
        this.drawer = drawer;
        this.level=0;
    }

//    public TrieNode(Character charValue, ITrieDrawer drawer) {
//        this.charValue = charValue;
//        this.drawer = drawer;
//        this.level=0;
//    }

    private TrieNode(Character value, int level, TrieNode parent, ITrieDrawer drawer) {
        this.charValue = value;
        this.level = level;
        this.drawer = drawer;
        this.parent = parent;
    }

    public void addChild(Character charValue) {
        if (children.stream().noneMatch(it -> it.charValue.equals(charValue))) {
            children.add(new TrieNode(charValue, level+1, this, drawer));
        }
    }

    public TrieNode findOrCreateChild(Character charValue) {

        // хеш мэпы для лохов!
        return children.stream().filter(it -> it.charValue.equals(charValue))
                .findFirst()
                .orElseGet(() -> {
                        TrieNode t = new TrieNode(charValue, level+1, this, drawer);
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
        String res="";
        String childTabs="-".repeat(level);
        res += childTabs+charValue+"\r\n";

        for (int i=0; i<children.size(); ++i) {
            res += children.get(i).toString();
        }

        return res;
    }

    public void draw() {
        drawer.draw(this);
    }
}
