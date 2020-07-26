package nowcode;

public class Solution_JZ12 {

    public double Power(double base, int exponent) {
        return Math.pow(base, exponent);
    }

    public double Power1(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        double result = 1;
        if (exponent > 0) {
            for (int i = 0; i < exponent; i++) {
                result *= base;
            }
        } else {
            for (int i = 0; i < Math.abs(exponent); i++) {
                result *= base;
            }
            result = 1 / result;
        }

        return result;
    }

}
