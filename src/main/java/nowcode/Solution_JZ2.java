package nowcode;

public class Solution_JZ2 {
    public String replaceSpace(StringBuffer str) {

        String toString = str.toString();
        return toString.replaceAll(" ", "%20");
    }
}
