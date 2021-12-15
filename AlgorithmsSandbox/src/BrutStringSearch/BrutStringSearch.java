package BrutStringSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BrutStringSearch implements SubstringSearcher{
    List<String> dictionary = new ArrayList<>();

    @Override
    public void addToDictionary(String s) {
        dictionary.add(s);
    }



    @Override
    public HashMap<String, List<Integer>> searchString(String s) {
        

        return null;
    }
}
