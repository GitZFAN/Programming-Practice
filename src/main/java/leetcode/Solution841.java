package leetcode;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 841. 钥匙和房间
 *
 * @author fzhang
 * @date 2020-08-31
 */
public class Solution841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> visitRoomsSet = new HashSet<>();
        Deque<Integer> passQueue = new LinkedList<>();

        passQueue.offer(0);

        while (!passQueue.isEmpty()) {
            // 取出一把钥匙
            Integer key = passQueue.poll();

            // 打开对应房间，取出其中所有钥匙
            visitRoomsSet.add(key);
            List<Integer> list = rooms.get(key);
            for (Integer integer : list) {
                if (!visitRoomsSet.contains(integer)) {
                    passQueue.offer(integer);
                }
            }
        }

        return visitRoomsSet.size() == rooms.size();
    }
}
