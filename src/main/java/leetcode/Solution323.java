package leetcode;

import java.util.*;

/**
 * 332. 重新安排行程
 *
 * @author fzhang
 * @date 2020-08-28
 */
public class Solution323 {

    HashMap<String, List<String>> hashMap = new HashMap<>();

    /**
     * 建一个状态集合，表示每张机票的使用情况
     */
    HashMap<String, int[]> usedHashMap = new HashMap<>();

    LinkedList<String> result;

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>(5);
        ArrayList<String> ticket1 = new ArrayList<>(2);
        ticket1.add("JFK");
        ticket1.add("SFO");
        ArrayList<String> ticket2 = new ArrayList<>(2);
        ticket2.add("JFK");
        ticket2.add("ATL");
        ArrayList<String> ticket3 = new ArrayList<>(2);
        ticket3.add("SFO");
        ticket3.add("ATL");
        ArrayList<String> ticket4 = new ArrayList<>(2);
        ticket4.add("ATL");
        ticket4.add("JFK");
        ArrayList<String> ticket5 = new ArrayList<>(2);
        ticket5.add("ATL");
        ticket5.add("SFO");

        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);

        Solution323 solution323 = new Solution323();
        List<String> itinerary = solution323.findItinerary(tickets);
        System.out.println("itinerary = " + itinerary);
    }

    /**
     * 回溯法
     *
     * @param tickets 所有的“机票”（[from, to]）
     * @return 字典序最小的行程排列（涵盖所有的机票）
     */
    public List<String> findItinerary(List<List<String>> tickets) {

        // 根据 出发地 归纳所有的 机票
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            if (!hashMap.containsKey(from)) {
                List<String> list = new LinkedList<>();
                list.add(to);
                hashMap.put(from, list);
            } else {
                List<String> list = hashMap.get(from);
                list.add(to);
            }
        }

        // 根据 字典序 对 到达地 进行排序（顺便完成状态集合的初始化）
        for (Map.Entry<String, List<String>> entry : hashMap.entrySet()) {
            List<String> list = entry.getValue();
            list.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });

            int[] ints = new int[list.size()];
            usedHashMap.put(entry.getKey(), ints);
        }

        result = new LinkedList<>();
        String from = "JFK";
        result.add(from);
        visitFrom(from);
        return result;
    }

    private boolean visitFrom(String from) {
        List<String> cityList = hashMap.get(from);
        int[] isVisit = usedHashMap.get(from);

        if (isVisit != null) {
            int i = 0;
            for (; i < isVisit.length; i++) {
                if (isVisit[i] == 0) {
                    isVisit[i] = 1;
                    result.add(cityList.get(i));
                    boolean success = visitFrom(cityList.get(i));
                    if (success) {
                        return true;
                    } else {
                        isVisit[i] = 0;
                        result.removeLast();
                    }
                }
            }

            if (i == isVisit.length) {
                // 表示当前 from 的所有机票已经使用
                // 判断是否能构成最终答案
                for (int[] value : usedHashMap.values()) {
                    for (int j : value) {
                        if (j == 0) {
                            return false;
                        }
                    }
                }
                return true;
            }
            return false;
        }

        // 表示当前 from 的所有机票已经使用
        // 判断是否能构成最终答案
        for (int[] value : usedHashMap.values()) {
            for (int j : value) {
                if (j == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
