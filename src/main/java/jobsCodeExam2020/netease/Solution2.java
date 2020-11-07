package jobsCodeExam2020.netease;

import java.util.*;

/**
 * @author 13585
 * @date 2020-09-12
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stopWords = scanner.nextLine();
        String nextLine1 = scanner.nextLine();
        String nextLine2 = scanner.nextLine();
        String[] stopList = stopWords.split(" ");
        List<String> list1 = Arrays.asList(nextLine1.split(" "));
        List<String> list2 = Arrays.asList(nextLine2.split(" "));

        for (String s : stopList) {
            list1.remove(s);
            list2.remove(s);
        }

        int modify = 0;

        if (list1.size() == list2.size()) {
            for (int i = 0; i < list1.size(); i++) {
                if (!list1.get(i).equals(list2.get(i))) {
                    modify += 1;
                }
            }

        } else if (list1.size() < list2.size()) {
            modify += list2.size() - list1.size();
            for (String s : list1) {
                if (!list2.contains(s)) {
                    modify += 1;
                }
            }
        } else {
            modify += list1.size() - list2.size();
            modify += list2.size();
            for (String s : list2) {
                if (list1.contains(s)) {
                    modify -= 1;
                }
            }
        }
        System.out.println(modify);
    }

}
