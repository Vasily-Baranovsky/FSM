package Korasik;

import java.util.*;

public class TrieNode {

    private final Character EMPTY_CHAR_VALUE='.';
    protected Map<Character, TrieNode> children = new TreeMap<>();

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

    private TrieNode suffixLink;

    private TrieNode outputLink;

    public TrieNode getSuffixLink() {
        return suffixLink;
    }

    public void setSuffixLink(TrieNode suffixLink) {
        this.suffixLink = suffixLink;
    }

    public TrieNode getOutputLink() {
        return outputLink;
    }

    public void setOutputLink(TrieNode outputLink) {
        this.outputLink = outputLink;
    }

    // only for printing of the trie
    public int getLevel() {
        int level=0;
        TrieNode tn = this.parent;
        while(tn!=null) {
            level++;
            tn = tn.parent;
        }

        return level;
    }

    private TrieNode parent = null;       // only for printing of the trie
    public TrieNode getParent() {
        return parent;
    }

    public TrieNode() {
        this.charValue = EMPTY_CHAR_VALUE;
    }
    public TrieNode(ITrieDrawer drawer) {
        this.charValue = EMPTY_CHAR_VALUE;
        this.drawer = drawer;
    }

    private TrieNode(Character value, TrieNode parent, ITrieDrawer drawer) {
        this.charValue = value;
        this.drawer = drawer;
        this.parent = parent;
    }

    public void addChild(Character charValue) {
        if (!children.containsKey(charValue)) {
            children.put(charValue, new TrieNode(charValue, this, drawer));
        }
    }

   public TrieNode findOrCreateChild(Character charValue) {
       if (!children.containsKey(charValue)) {
           TrieNode t = new TrieNode(charValue, this, drawer);
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
        String childTabs="-".repeat(getLevel());
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

    public void buildSuffixLinks() {
        TrieNode root = this;
        root.setSuffixLink(null);
        LinkedList<TrieNode> nodesQueue = new LinkedList<>();

        for (TrieNode child: root.getChildren().values()) {
            child.setSuffixLink(root);
            child.setOutputLink(null);
            nodesQueue.add(child);
        }

        while(!nodesQueue.isEmpty()) {
            TrieNode currentNode = nodesQueue.pop();
            for(TrieNode child: currentNode.getChildren().values()) {
                TrieNode currentSuffixCandidateParent = currentNode.getSuffixLink();
                child.setSuffixLink(root);
                while (currentSuffixCandidateParent != null) {
                    TrieNode foundNodeBySuffixLink = currentSuffixCandidateParent.findChild(child.getCharValue());
                    if(foundNodeBySuffixLink != null) {
                        if (foundNodeBySuffixLink.endOfWord) {
                            child.setOutputLink(foundNodeBySuffixLink);
                        } else {
                            child.setOutputLink(foundNodeBySuffixLink.getOutputLink());
                        }
                        child.setSuffixLink(foundNodeBySuffixLink);
                        break;
                    } else {
                        currentSuffixCandidateParent = currentSuffixCandidateParent.getSuffixLink();
                    }
                }
                nodesQueue.add(child);
            }
        }
    }
}
