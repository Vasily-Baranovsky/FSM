package Korasik;

public class TrieDrawerByDefault implements ITrieDrawer {

    @Override
    public void draw(TrieNode tn) {
        //System.out.println(root.toString());

        String childTabs="-".repeat(tn.getLevel());
        System.out.println(childTabs+tn.getCharValue());

        for (int i=0; i<tn.children.size(); ++i) {
            tn.children.get(i).draw();
        }
    }
}
