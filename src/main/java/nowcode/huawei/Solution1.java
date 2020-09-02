package nowcode.huawei;

import java.util.*;

/**
 * 分类排序问题
 *
 * @author 13585
 * @date 2020-09-02
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<Chose, Integer> hashMap = new HashMap<>();
        ArrayList<Chose> list1 = new ArrayList<>();
        ArrayList<Chose> list2 = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int i1 = scanner.nextInt();
            int i2 = scanner.nextInt();
            Chose chose = new Chose(i1, i2);
            hashMap.put(chose, i);
            if (i2 == 1) {
                list1.add(chose);
            } else {
                list2.add(chose);
            }
        }

        list1.sort(new Comparator<Chose>() {
            @Override
            public int compare(Chose o1, Chose o2) {
                return o1.num - o2.num;
            }
        });
        list2.sort(new Comparator<Chose>() {
            @Override
            public int compare(Chose o1, Chose o2) {
                return o1.num - o2.num;
            }
        });

        if (list1.size() < 3) {
            if (list2.size() < 3) {
                // 不符合
                System.out.println("null");
            } else {
                // 取后面3个
                int sum = 0;
                for (int i = list2.size() - 3; i < list2.size(); i++) {
                    Chose chose = list2.get(i);
                    sum += chose.num;
                    if (i < list2.size() - 1) {
                        System.out.print(hashMap.get(chose) + " ");
                    } else {
                        System.out.println(hashMap.get(chose));
                    }
                }
                System.out.println(2);
                System.out.println(sum);
            }
        } else if (list2.size() < 3) {
            int sum = 0;
            for (int i = list1.size() - 3; i < list1.size(); i++) {
                Chose chose = list1.get(i);
                sum += chose.num;
                if (i < list1.size() - 1) {
                    System.out.print(hashMap.get(chose) + " ");
                } else {
                    System.out.println(hashMap.get(chose));
                }
            }
            System.out.println(1);
            System.out.println(sum);
        } else {
            // 同时符合
            int sum1 = 0;
            for (int i = list1.size() - 3; i < list1.size(); i++) {
                Chose chose = list1.get(i);
                sum1 += chose.num;
            }
            int sum2 = 0;
            for (int i = list2.size() - 3; i < list2.size(); i++) {
                Chose chose = list2.get(i);
                sum2 += chose.num;
            }

            if (sum1 > sum2) {
                // 输出list1
                int sum = 0;
                for (int i = list1.size() - 3; i < list1.size(); i++) {
                    Chose chose = list1.get(i);
                    sum += chose.num;
                    if (i < list1.size() - 1) {
                        System.out.print(hashMap.get(chose) + " ");
                    } else {
                        System.out.println(hashMap.get(chose));
                    }
                }
                System.out.println(1);
                System.out.println(sum);
            } else if (sum1 < sum2) {
                // 输出list2
                int sum = 0;
                for (int i = list2.size() - 3; i < list2.size(); i++) {
                    Chose chose = list2.get(i);
                    sum += chose.num;
                    if (i < list2.size() - 1) {
                        System.out.print(hashMap.get(chose) + " ");
                    } else {
                        System.out.println(hashMap.get(chose));
                    }
                }
                System.out.println(2);
                System.out.println(sum);
            } else {
                // 判断 下标，输出小的
                int indexSum1 = 0;
                for (int i = list1.size() - 3; i < list1.size(); i++) {
                    Chose chose = list1.get(i);
                    indexSum1 += hashMap.get(chose);
                }

                int indexSum2 = 0;
                for (int i = list1.size() - 3; i < list1.size(); i++) {
                    Chose chose = list1.get(i);
                    indexSum2 += hashMap.get(chose);
                }

                if (indexSum1 < indexSum2) {
                    // 输出list1
                    int sum = 0;
                    for (int i = list1.size() - 3; i < list1.size(); i++) {
                        Chose chose = list1.get(i);
                        sum += chose.num;
                        if (i < list1.size() - 1) {
                            System.out.print(hashMap.get(chose) + " ");
                        } else {
                            System.out.println(hashMap.get(chose));
                        }
                    }
                    System.out.println(1);
                    System.out.println(sum);
                } else {
                    // 输出list2
                    int sum = 0;
                    for (int i = list2.size() - 3; i < list2.size(); i++) {
                        Chose chose = list2.get(i);
                        sum += chose.num;
                        if (i < list2.size() - 1) {
                            System.out.print(hashMap.get(chose) + " ");
                        } else {
                            System.out.println(hashMap.get(chose));
                        }
                    }
                    System.out.println(2);
                    System.out.println(sum);
                }
            }
        }
    }
}

class Chose {
    int num;
    int color;

    Chose(int num, int color) {
        this.num = num;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Chose chose = (Chose) o;
        return num == chose.num &&
                color == chose.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, color);
    }
}