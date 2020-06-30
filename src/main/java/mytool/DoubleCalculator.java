package mytool;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author TheFan
 */
public class DoubleCalculator {

    /**
     * 将字符串转化成List
     *
     * @param str
     * @return
     */
    public ArrayList<String> getStringList(String str) {
        ArrayList<String> result = new ArrayList<>();
        StringBuilder num = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)) || str.charAt(i) == '.') {
                num.append(str.charAt(i));
            } else {
                if (str.charAt(i) == ' ') {
                    continue;
                }
                if (!"".equals(num.toString())) {
                    result.add(num.toString());
                }
                // result.add(String.valueOf(str.charAt(i)))  也行
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
     * @param inOrderList
     * @return
     */
    public ArrayList<String> getPostOrder(ArrayList<String> inOrderList) {

        ArrayList<String> result = new ArrayList<>();
        Stack<String> stack = new Stack<>();
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
     * @param postOrder
     * @return
     */
    public Double calculate(ArrayList<String> postOrder) {
        Stack<Double> stack = new Stack<>();
        for (String s : postOrder) {
            if (Character.isDigit(s.charAt(0))) {
                stack.push(Double.valueOf(s));
            } else {
                Double back = stack.pop();
                Double front = stack.pop();
                double res = 0;
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
     * @param peek
     * @param cur
     * @return
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
        DoubleCalculator doubleCalculator = new DoubleCalculator();
        String s = "1.2 + (2.3 * 3.0 - 5.6 + 7.0) * (2 + 90) / 2";

        //String转换为List
        ArrayList<String> result = doubleCalculator.getStringList(s);

        //中缀变后缀
        result = doubleCalculator.getPostOrder(result);

        //计算
        Double i = doubleCalculator.calculate(result);

        System.out.print(s + " = ");
        System.out.println(i);
    }

    public Double calculateStringExpression(String exp) {
        ArrayList<String> stringList = getStringList(exp);
        ArrayList<String> postOrderExp = getPostOrder(stringList);
        return calculate(postOrderExp);
    }
}
