package jobsCodeExam2020.beike;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author 13585
 * @date 2020-10-26
 */
public class Solution4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nums = scanner.nextInt();
        for (int i = 0; i < nums; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            LinkedList<Item> linkedList = new LinkedList<>();
            int maxB = Integer.MIN_VALUE;
            for (int j = 0; j < m; j++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                maxB = Math.max(maxB, b);
                Item item = new Item(a, b, false);
                linkedList.add(item);
            }

            long result = maxResult(linkedList, n, maxB);
            System.out.println(result);

        }
    }

    private static long maxResult(LinkedList<Item> linkedList, int n, int maxB) {
        linkedList.sort(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o2.a.compareTo(o1.a);
            }
        });

        long result = 0;
        for (int i = 0; i < linkedList.size() && n > 0; i++) {
            Item item = linkedList.get(i);
            if (item.a >= maxB) {
                result += item.a;
                n -= 1;
                item.used = true;
            }
        }

        if (n > 0) {
            int finalN = n;
            linkedList.sort(new Comparator<Item>() {
                @Override
                public int compare(Item o1, Item o2) {
                    Double a = 0.0;
                    if (o1.used) {
                        a += o1.b*finalN;
                    } else {
                        a += o1.a + o1.b*(finalN -1);
                    }
                    Double b = 0.0;
                    if (o2.used) {
                        b += o2.b*finalN;
                    } else {
                        b += o2.a + o2.b*(finalN-1);
                    }
                    return b.compareTo(a);
                }
            });
            Item item = linkedList.get(0);
            if (item.used) {
                result += item.b*finalN;
            } else {
                result += item.a + item.b*(finalN-1);
            }
        }
        return result;
    }

}

class Item {
    Integer a;
    Integer b;
    boolean used;

    public Item(int a, int b, boolean used) {
        this.a = a;
        this.b = b;
        this.used = used;
    }
}
