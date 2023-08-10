package services;

import java.util.ArrayList;
import java.util.Map;

public class Logger {
    public void print(String response, Map<Character, Integer> charCountMap) {
        System.out.println("response: " + response);
        float totalFrequency = 0;
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue() + " " + ending(entry.getValue()));
            totalFrequency += entry.getValue();
        }
        float averageFrequency = totalFrequency / charCountMap.size();
        System.out.println("Среднее значение частоты: " + (int) totalFrequency +  " / " + charCountMap.size()
        + " = " + averageFrequency);
        System.out.println("Символ наиболее близкого значения частоты к среднему значанию: ");
               closestSymbol(charCountMap, averageFrequency).forEach(cl ->
                       System.out.println(cl.toString() + " (" + (int) cl + ")"));
    }

    String ending(int value) {
        String answer;
        if (((value % 10 == 2) && (value != 12)) || ((value % 10 == 3) && (value != 13)) || ((value % 10 == 4) && (value != 14))) {
            answer = "раза";
        } else {
           answer = "раз";
        }
        return answer;
    }

    ArrayList<Character> closestSymbol(Map<Character, Integer> charCountMap, float averageFrequency){
        int closestSymbol = 0;
        float closestFrequencyDifference = Integer.MAX_VALUE;
        ArrayList<Character> allSymbol = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if ((Math.abs(entry.getValue() - averageFrequency)) < closestFrequencyDifference){
                closestSymbol = entry.getValue();
                closestFrequencyDifference = Math.abs(entry.getValue() - averageFrequency);
            }
        }
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() == closestSymbol){
                allSymbol.add(entry.getKey());
            }
        }
        return allSymbol;
    }
}