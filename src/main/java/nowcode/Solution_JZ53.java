package nowcode;

public class Solution_JZ53 {
    public boolean isNumeric(char[] str) {
        String s = String.valueOf(str);

        try {
            Double.valueOf(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
