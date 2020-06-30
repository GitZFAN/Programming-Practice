import mytool.DoubleCalculator;

import java.util.HashMap;
import java.util.Map;

public class OperatorFilled {
    public static void main(String[] args) {
        Map<Integer, String> opsMap = new HashMap<>();
        opsMap.put(0, "+");
        opsMap.put(1, "-");
        opsMap.put(2, "*");
        opsMap.put(3, "/");

        DoubleCalculator doubleCalculator = new DoubleCalculator();

        double[] nums = {0.8, 3, 0.45, 2};

        for (int i = 0; i < 4; i++) {
            String stringExpression1 = nums[0] + opsMap.get(i) + nums[1];

            for (int j = 0; j < 4; j++) {
                String stringExpression2 = stringExpression1 + opsMap.get(j) + nums[2];

                for (int k = 0; k < 4; k++) {
                    String stringExpression3 = stringExpression2 + opsMap.get(k) + nums[3];
                    double result = doubleCalculator.calculateStringExpression(stringExpression3);

                    if (Math.abs(result-0.5) < 0.01) {
                        System.out.println(stringExpression3 + " = " + result);
                        return;
                    }
                }
            }
        }
    }

}
