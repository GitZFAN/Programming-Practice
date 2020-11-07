package jobsCodeExam2020.vivo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * （按顺序）编译文件
 *
 * @author 13585
 * @date 2020-09-12
 */
public class Solution3 {
    public String compileSeq(String input) {
        // write code here
        // "1,2,-1,1"
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();

        String[] split = input.split(",");

        for (int i = 0; i < split.length; i++) {
            hashMap.put(i, new ArrayList<>(split.length - 1));
        }

        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < split.length; i++) {
            int dependency = Integer.parseInt(split[i]);
            if (dependency == -1) {
                linkedList.add(i);
            } else {
                ArrayList<Integer> list = hashMap.get(dependency);
                list.add(i);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!linkedList.isEmpty()) {
            Collections.sort(linkedList);
            Integer poll = linkedList.poll();
            stringBuilder.append(poll).append(",");
            ArrayList<Integer> integers = hashMap.get(poll);
            linkedList.addAll(integers);
        }
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());

        return stringBuilder.toString();
    }
}
