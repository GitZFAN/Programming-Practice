package jobsCodeExam2020.huawei;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 统计源代码中有效代码行数
 *
 * @author 13585
 * @date 2020-09-25
 */
public class Solution5 {
    public static void main(String[] args) throws IOException {
        String filePath = "/home/user/a.txt";

        FileInputStream fileInputStream = new FileInputStream(filePath);
        InputStreamReader streamReader = new InputStreamReader(fileInputStream);
        BufferedReader reader = new BufferedReader(streamReader);

        long count = 0;
        boolean flag = false;
        String line = reader.readLine();
        while (line != null) {
            if (line.contains("/*")) {
                if (!line.trim().startsWith("/*")) {
                    count += 1;
                }
                flag = true;
            }
            if (!flag) {
                if (!line.trim().startsWith("//") && !"".equals(line.trim())) {
                    count += 1;
                }
            } else {
                if (line.contains("*/")) {
                    flag = false;
                }
                if (!line.trim().endsWith("*/")) {
                    count += 1;
                }
            }

            line = reader.readLine();
        }

        System.out.println("count = " + count);

        reader.close();
    }
}
