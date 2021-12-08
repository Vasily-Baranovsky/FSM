package Korasik;

public class TrieDrawerHorizontal implements ITrieDrawer {
    @Override
    public void draw(TrieNode root) {
        TrieNode tn = root;

        // don't print root
        if (tn.getLevel() > 0) {
            String childTabs =  (tn.getParent().children.indexOf(tn)>0) ? "-".repeat(tn.getLevel()*2 - 1) : "-";
            System.out.print(childTabs + tn.getCharValue());
        }

        if (tn.children.size() == 0) {
            System.out.println();
        }

        for (int i=0; i<tn.children.size(); ++i) {
            tn.children.get(i).draw();
        }
    }
}
