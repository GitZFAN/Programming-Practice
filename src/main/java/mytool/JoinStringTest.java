package mytool;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * String 拼接
 *
 * @author fzhang
 * @date 2020-09-04
 */
public class JoinStringTest {
    public static void main(String[] args) {
        // 测试字符串拼接的3中方法
        String result = "Hello Bob, Alice, Grace!";
        String[] names = {"Bob", "Alice", "Grace"};
        System.out.println("names = " + Arrays.toString(names));
        System.out.println("required result = " + result);

        String string1 = combineString1("Hello ", names, ", ", "!");
        System.out.println("string1 = " + string1);
        System.out.println(result.equals(string1) ? "Success" : "Failed");

        String string2 = combineString2("Hello ", names, ", ", "!");
        System.out.println("string2 = " + string2);
        System.out.println(result.equals(string2) ? "Success" : "Failed");

        String string3 = combineString3("Hello ", names, ", ", "!");
        System.out.println("string3 = " + string3);
        System.out.println(result.equals(string3) ? "Success" : "Failed");

        // 测试 SELECT 语句拼接
        String[] fields = {"name", "position", "salary"};
        String table = "employee";
        String select = buildSelectSql(table, fields);
        System.out.println(select);
        System.out.println("SELECT name, position, salary FROM employee".equals(select) ? "测试成功" : "测试失败");
    }

    private static String combineString3(String preStr, String[] strings, String split, String postStr) {
        String join = String.join(split, strings);

        return preStr + join + postStr;
    }

    private static String combineString2(String preStr, String[] strings, String split, String postStr) {
        StringJoiner stringJoiner = new StringJoiner(split, preStr, postStr);
        for (String s : strings) {
            stringJoiner.add(s);
        }
        return stringJoiner.toString();
    }


    private static String combineString1(String preStr, String[] strings, String split, String postStr) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(preStr);
        for (String s : strings) {
            stringBuilder.append(s).append(split);
        }
        stringBuilder.delete(stringBuilder.length() - split.length(), stringBuilder.length());
        stringBuilder.append(postStr);
        return stringBuilder.toString();
    }

    private static String buildSelectSql(String table, String[] fields) {
        StringJoiner stringJoiner = new StringJoiner(", ");
        for (String s : fields) {
            stringJoiner.add(s);
        }
        String result = "SELECT " + stringJoiner.toString() + " FROM " + table;
        String join = String.join(", ", fields);
        return "SELECT " + join + " FROM " + table;
    }
}
