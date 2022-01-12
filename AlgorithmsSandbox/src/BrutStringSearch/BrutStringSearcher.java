package BrutStringSearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BrutStringSearcher implements SubstringSearcher{
    private List<String> dictionary = new ArrayList<>();

    public BrutStringSearcher(String[] dictionary) {
        for (String s:dictionary) {
            addToDictionary(s);
        }
    }

    @Override
    public void addToDictionary(String s) {
        dictionary.add(s);
    }


    @Override
    public HashMap<String, List<Integer>> searchString(String initialString) {
        // набор фактов на какой позиции какой символ есть - мы можем получить символ на любой позиции строки s, аналогично для строк в словаре
        // создание гиптез - делаем ленивый алгоритм

        HashMap<String, List<Integer>> resultSubstringMap = new HashMap<>();

        for (int i = 0; i < initialString.length(); i++) {
            for (int j = 0; j < dictionary.size(); j++) {
                boolean isSubstring = true;
                String searchableString = dictionary.get(j);
                for (int k = 0; k < searchableString.length(); k ++) {

                    if ( i + k >= initialString.length() ||
                            initialString.charAt(i + k) != searchableString.charAt(k)) {
                        isSubstring = false;
                        break;
                    }
                }
                if (isSubstring) {
                    List<Integer> indexes = resultSubstringMap.computeIfAbsent(searchableString, k -> new ArrayList<>());
                    indexes.add(i);
                }
            }
        }

        // проверка гипотез
        // сохранение живых гипотез
        // возвращение набора результирующих фактов (выжившие гипотезы, которые стали фактами) в виде HashMap



        return resultSubstringMap;
    }


}
