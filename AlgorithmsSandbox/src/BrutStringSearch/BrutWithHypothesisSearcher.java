package BrutStringSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BrutWithHypothesisSearcher implements SubstringSearcher{
    private List<String> dictionary = new ArrayList<>();

    public BrutWithHypothesisSearcher(String[] dictionary) {
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
        HashMap<String, List<Integer>> resultSubstringMap = new HashMap<>();
        ArrayList<Hypothesis> hypotheses = new ArrayList<>();

        for (int i = 0; i < initialString.length(); i++) {
            //берем символ в исходной строке
            char currentChar = initialString.charAt(i);
            //проходим по гипотезам и проверяем их, удаляем несуществующие и выдаем резульаты тех, которые совпали и те которые срадботали целиком тоже удаляем
            int j = 0;
            while (j < hypotheses.size()) {
                if ()

                hypotheses.get(j).checkHypothesisState(currentChar);
            }
            //проходим по всему словарю и проверяем слова, которые начинаеются с этого символа
            //далее нужно создать гиптезы для слов в словаре, у которых первый символ совпадает с символом из строки, в которой ищум
            //

            //гипотеза: что в исходной строке начиная с какого-то символа существует подстрока равная конкретной строке из словаря
            //в гипотезе хранится: строка из словаря, индекс символа в исходной строке и то, насколько мы эту гипотезу проверили, т.е. индекс до которого мы проверили строку из словаря (индекс именно в строке словаря)

        }
    }
}s
