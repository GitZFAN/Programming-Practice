package nowcode;

public class Solution_JZ37 {
    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0) {
            return 0;
        }

        boolean isIncreaseOrder = true;

        int length = array.length;
        int left = 0;
        int right = length-1;
        if (array[left] < array[right]) {
            // 升序数组
            isIncreaseOrder = true;
        } else if (array[left] > array[right]) {
            // 降序数组
            isIncreaseOrder = false;
        } else {
            // 相同数组
            if (array[left] == k) {
                return length;
            } else {
                return 0;
            }
        }

        int index = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == k) {
                index = mid;
                break;
            }
            if (array[mid] < k) {
                if (isIncreaseOrder) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (isIncreaseOrder) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        if (index != -1) {
            // 在数组中找到了数字k，接下来往两边扩张，找到相同的数字个数
            int result = 1;
            for (int i = index+1; i < length; i++) {
                if (array[i] == k) {
                    result += 1;
                }
            }
            for (int i = index-1; i >= 0; i--) {
                if (array[i] == k) {
                    result += 1;
                }
            }
            return result;
        }
        return 0;
    }
}
