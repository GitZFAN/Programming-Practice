package nowcode;

public class Solution_JZ23 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }

        return isSquenceOfBST(sequence, 0, sequence.length - 1);
    }

    private boolean isSquenceOfBST(int[] sequence, int from, int end) {
        if (from == end) {
            return true;
        }

        int rootVal = sequence[end];

        // 记录第一个大于rootVal的sequence中index
        int index = from;
        for (; index < end; index++) {
            if (sequence[index] > rootVal) {
                break;
            }
        }

        if (index == end) {
            // sequence中from到end-1的所有元素都比rootVal小
            return isSquenceOfBST(sequence, from, end - 1);
        } else if (index == from) {
            // sequence中from所在元素比rootVal大
            int i = index;
            for (; i < end; i++) {
                if (sequence[i] < rootVal) {
                    break;
                }
            }
            if (i == end) {
                // sequence中从from到end-1的所有元素都比rootVal大
                return isSquenceOfBST(sequence, from, end - 1);
            }
        } else {
            // sequence中间index所在元素比rootVal大
            int i = index;
            for (; i < end; i++) {
                if (sequence[i] < rootVal) {
                    break;
                }
            }
            if (i == end) {
                // sequence中从from到index-1的所有元素都比rootVal小，从index到end-1所有元素都比rootVal大
                return isSquenceOfBST(sequence, from, index - 1) &&
                        isSquenceOfBST(sequence, index, end - 1);
            }
        }

        return false;
    }


}
