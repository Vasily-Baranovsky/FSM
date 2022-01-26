package Korasik;

public class Test1 {
    public static void main(String[] args) {
        TrieNode tn = new TrieNode();
                //, new TrieDrawerByDefault());
//                , new TrieDrawerHorizontal());

        tn.addWord("test");
//        System.out.println("draw:");
//        tn.draw();
//        System.out.println("~~~draw");
        tn.addWord("ttest");
//        System.out.println("draw:");
//        tn.draw();
//        System.out.println("~~~draw");
        tn.addWord("tttest");
//        System.out.println("draw:");
//        tn.draw();
//        System.out.println("~~~draw");

//        System.out.println(tn.toString());
        tn.addWord("abirvalg");
        tn.addWord("abirglav");


//        System.out.println(tn.toString());
        tn.draw();
    }
}
