package Korasik;

public class Test1 {
    public static void main(String[] args) {
        TrieNode tn = new TrieNode(new TrieDrawerHorizontal());
                //, new TrieDrawerByDefault());
//                , new TrieDrawerHorizontal());

        tn.addWord("test");
        tn.addWord("ttest");
        tn.addWord("tttest");
        tn.addWord("abirvalg");
        tn.addWord("abirglav");


//        System.out.println(tn.toString());
        tn.draw();
    }
}
