package services;

import java.util.HashMap;
import java.util.Map;

public class TextUtils {
    public Map<Character, Integer> countChars(String str) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char ch : str.toCharArray()) {
            if (charCountMap.containsKey(ch)) {
                charCountMap.put(ch, charCountMap.get(ch) + 1);
            } else {
                charCountMap.put(ch, 1);
            }
        }
        return charCountMap;
    }
}