package nowcode;

public class Solution_JZ44 {
    public String ReverseSentence(String str) {
        if ("".equals(str.trim())) {
            return str;
        }

        String[] split = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            stringBuilder.append(split[i] + " ");
        }
        String result = stringBuilder.toString();
        return result.trim();
    }
}
