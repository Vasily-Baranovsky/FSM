package Korasik;

import java.util.*;

public class TrieNode {

    private final Character EMPTY_CHAR_VALUE='.';
    protected Map<Character, TrieNode> children = new HashMap<>();

    private Character charValue;
    public Character getCharValue() {
        return charValue;
    }

    protected boolean endOfWord=false;
    public boolean isEndOfWord() {
        return endOfWord;
    }

    protected String word;


    private ITrieDrawer drawer = new TrieDrawerByDefault(); // only for printing of the trie

    private int level;                  // only for printing of the trie
    public int getLevel() {
        return level;
    }

    private TrieNode parent = null;       // only for printing of the trie
    public TrieNode getParent() {
        return parent;
    }

    public TrieNode() {
        this.charValue = EMPTY_CHAR_VALUE;
        this.level=0;
    }
    public TrieNode(ITrieDrawer drawer) {
        this.charValue = EMPTY_CHAR_VALUE;
        this.drawer = drawer;
        this.level=0;
    }

    private TrieNode(Character value, int level, TrieNode parent, ITrieDrawer drawer) {
        this.charValue = value;
        this.level = level;
        this.drawer = drawer;
        this.parent = parent;
    }

    public void addChild(Character charValue) {
        if (!children.containsKey(charValue)) {
            children.put(charValue, new TrieNode(charValue, level+1, this, drawer));
        }
    }

   public TrieNode findOrCreateChild(Character charValue) {
       if (!children.containsKey(charValue)) {
           TrieNode t = new TrieNode(charValue, level+1, this, drawer);
           children.put(charValue, t);
           return t;
       }
       else {
           return children.get(charValue);
       }
    }

    public TrieNode findChild(Character charValue) {
        // Done: Заменить List children на Map children
        return children.get(charValue);
    }

    public void addWord(String word) {

        TrieNode tn = this;
        for (int i=0; i<word.length(); ++i) {
            tn = tn.findOrCreateChild(word.charAt(i));
        }

        tn.endOfWord = true;
        tn.word = word;
    }

    @Override
    public String toString() {
        StringBuilder res= new StringBuilder();
        String childTabs="-".repeat(level);
        res.append(childTabs).append(charValue).append("\r\n");

        List<TrieNode> lst = new ArrayList<>(children.values());
        for (TrieNode child : lst) {
            res.append(child.toString());
        }
        return res.toString();
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public String getWord() throws GettingWordFromNonEndNodeException {
        if (endOfWord) {
            return word;
        } else {
            throw new GettingWordFromNonEndNodeException();
        }

    }

    public void draw() {
        drawer.draw(this);
    }
}
