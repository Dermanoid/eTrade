package util;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {

    private static final String delimiter = "@~";

    public static String getStringFromList(List<String> list) {
        String text = "";
        for (int i = 0; i < list.size(); i++) {
            text = text + list.get(i) + delimiter;
        }
        return text;      
    }
   
    public static List<String> getStringListFromString(String text) {
        String[] array = text.split(delimiter);
        List<String> list = new ArrayList<>();
        for (String s : array) {
            if (!s.isEmpty()) {
                list.add(s);
            }
        }
        return list;
    }
}
