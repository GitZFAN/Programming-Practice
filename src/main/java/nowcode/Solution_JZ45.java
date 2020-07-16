package nowcode;

public class Solution_JZ45 {
    public boolean isContinuous(int[] numbers) {
        if (numbers.length == 0) {
            return false;
        }

        // 冒泡排序实现
        // 第一层循环：需要为数组中 n-1 个位置找到对应数字
        for (int i = 0; i < numbers.length - 1; i++) {
            // 从后往前，填充数组中的每个位置
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int tmp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = tmp;
                }
            }
        }

        // 判断是否是顺子
        int min = 0;
        int max = numbers[numbers.length - 1];
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] != 0) {
                if (min == 0) {
                    min = numbers[i];
                }
                if (numbers[i] == numbers[i + 1]) {
                    return false;
                }
            }
        }

        return max - min < 5;
    }
}
