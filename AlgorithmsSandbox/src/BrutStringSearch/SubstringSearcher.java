package BrutStringSearch;

import java.util.HashMap;
import java.util.List;

public interface SubstringSearcher {
    public void addToDictionary(String s);

    public HashMap<String, List<Integer>> searchString(String s);
}
