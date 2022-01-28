package day05;

import java.util.HashMap;
import java.util.Map;

public class StringStatistics {

    public Map<Character, Integer> statForChars(String data) {
        Map<Character, Integer> stats = new HashMap<>();
        for (Character ch : data.toCharArray()) {
            if (stats.containsKey(ch)) {
                stats.put(ch, stats.get(ch) + 1);
            } else {
                stats.put(ch, 1);
            }
        }
        return stats;
    }
}
