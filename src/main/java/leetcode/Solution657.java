package leetcode;

/**
 * 657. 机器人能否返回原点
 *
 * @author fzhang
 * @date 2020-08-28
 */
public class Solution657 {
    public boolean judgeCircle(String moves) {
        int horizontal = 0;

        int vertical = 0;

        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            switch (c) {
                case 'U':
                    vertical += 1;
                    break;
                case 'D':
                    vertical -= 1;
                    break;
                case 'L':
                    horizontal -= 1;
                    break;
                case 'R':
                    horizontal += 1;
                    break;
                default:
                    break;
            }
        }

        return horizontal == 0 && vertical == 0;
    }
}
