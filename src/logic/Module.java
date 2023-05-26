package logic;

import java.util.HashMap;
import java.util.Map;

public class Module {

    private static Map<String, Integer> rankDict = new HashMap<>();
    private static Map<Integer, Character> suitDict = new HashMap<>();


    public static void initializeMaps() {
        rankDict.put("J", 11);
        rankDict.put("Q", 12);
        rankDict.put("K", 13);
        rankDict.put("A", 14);

        suitDict.put(0,'♦');
        suitDict.put(1,'♠');
        suitDict.put(2,'♣');
        suitDict.put(3,'♥');
    }

    public static int getRankAsInt(String rankAsString) {
        return rankDict.get(rankAsString);
    }

    public static char getSuitAsChar(int suitAsInt) {
        return suitDict.get(suitAsInt);
    }


}
