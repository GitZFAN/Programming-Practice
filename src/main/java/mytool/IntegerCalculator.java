package mytool;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author TheFan
 */
public class IntegerCalculator {

    /**
     * 将输入字符串格式原始计算表达式转化成List格式计算表达式
     *
     * @param str 原始计算表达式
     * @return 处理后的list格式计算表达式，每个元素表示一个数字或操作符
     */
    public ArrayList<String> getStringList(String str) {
        ArrayList<String> result = new ArrayList<>();
        StringBuilder num = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                num.append(str.charAt(i));
            } else {
                if (str.charAt(i) == ' ') {
                    continue;
                }
                if (!"".equals(num.toString())) {
                    result.add(num.toString());
                }
                // String.valueOf(str.charAt(i))
                result.add(str.substring(i, i + 1));
                num = new StringBuilder();
            }
        }
        if (!"".equals(num.toString())) {
            result.add(num.toString());
        }
        return result;
    }

    /**
     * 将中缀表达式转化为后缀表达式
     *
     * @param inOrderList 中缀表达式
     * @return 后缀表达式
     */
    public ArrayList<String> getPostOrder(ArrayList<String> inOrderList) {
        ArrayList<String> result = new ArrayList<>();

        LinkedList<String> stack = new LinkedList<>();
        for (String s : inOrderList) {
            if (Character.isDigit(s.charAt(0))) {
                result.add(s);
            } else {
                switch (s.charAt(0)) {
                    case '(':
                        stack.push(s);
                        break;
                    case ')':
                        while (!"(".equals(stack.peek())) {
                            result.add(stack.pop());
                        }
                        stack.pop();
                        break;
                    default:
                        while (!stack.isEmpty() && compare(stack.peek(), s)) {
                            result.add(stack.pop());
                        }
                        stack.push(s);
                        break;
                }
            }
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    /**
     * 计算后缀表达式
     *
     * @param postOrder 后缀表达式
     * @return 表达式的结果
     */
    public Integer calculate(ArrayList<String> postOrder) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (String s : postOrder) {
            if (Character.isDigit(s.charAt(0))) {
                stack.push(Integer.valueOf(s));
            } else {
                Integer back = stack.pop();
                Integer front = stack.pop();
                int res = 0;
                switch (s.charAt(0)) {
                    case '+':
                        res = front + back;
                        break;
                    case '-':
                        res = front - back;
                        break;
                    case '*':
                        res = front * back;
                        break;
                    case '/':
                        res = front / back;
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + s.charAt(0));
                }
                stack.push(res);
            }
        }
        return stack.pop();
    }

    /**
     * 比较运算符等级
     *
     * @param peek 栈顶的运算符
     * @param cur  新遇到的运算符
     * @return true if peek 的优先级高于 cur，otherwise return false.
     */
    public static boolean compare(String peek, String cur) {
        if ("*".equals(peek) && ("/".equals(cur) || "*".equals(cur) || "+".equals(cur) || "-".equals(cur))) {
            return true;
        } else if ("/".equals(peek) && ("/".equals(cur) || "*".equals(cur) || "+".equals(cur) || "-".equals(cur))) {
            return true;
        } else if ("+".equals(peek) && ("+".equals(cur) || "-".equals(cur))) {
            return true;
        } else if ("-".equals(peek) && ("+".equals(cur) || "-".equals(cur))) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        IntegerCalculator intCalculator = new IntegerCalculator();
        String s = "12 + (23 * 3 - 56 + 7) * (2 + 90) / 2";

        //String转换为List
        ArrayList<String> result = intCalculator.getStringList(s);

        //中缀变后缀
        result = intCalculator.getPostOrder(result);

        //计算
        int i = intCalculator.calculate(result);
        System.out.print(s + " = ");
        System.out.println(i);
    }
}