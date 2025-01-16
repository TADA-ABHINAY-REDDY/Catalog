
import java.io.FileReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.json.JSONTokener;

public class ShamirSecretSharing {

    public static void main(String[] args) {
        try {
            // Read input JSON files
            JSONObject input1 = new JSONObject(new JSONTokener(new FileReader("data/testcase1.json")));
            JSONObject input2 = new JSONObject(new JSONTokener(new FileReader("data/testcase2.json")));

            // Solve for both test cases
            System.out.println("Secret for Testcase 1: " + findSecret(input1));
            System.out.println("Secret for Testcase 2: " + findSecret(input2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static BigInteger findSecret(JSONObject input) {
        int k = input.getJSONObject("keys").getInt("k");

        // Parse the roots (x, y) pairs
        List<BigInteger> xValues = new ArrayList<>();
        List<BigInteger> yValues = new ArrayList<>();

        for (String key : input.keySet()) {
            if (key.equals("keys")) continue;

            BigInteger x = new BigInteger(key);
            JSONObject root = input.getJSONObject(key);
            int base = root.getInt("base");
            BigInteger y = new BigInteger(root.getString("value"), base);

            xValues.add(x);
            yValues.add(y);
        }

        // Use Lagrange interpolation to find the constant term c
        return lagrangeInterpolation(xValues, yValues, k);
    }

    private static BigInteger lagrangeInterpolation(List<BigInteger> xValues, List<BigInteger> yValues, int k) {
        BigInteger constant = BigInteger.ZERO;

        for (int i = 0; i < k; i++) {
            BigInteger numerator = BigInteger.ONE;
            BigInteger denominator = BigInteger.ONE;

            for (int j = 0; j < k; j++) {
                if (i != j) {
                    numerator = numerator.multiply(xValues.get(j).negate());
                    denominator = denominator.multiply(xValues.get(i).subtract(xValues.get(j)));
                }
            }

            // Calculate L_i(0) = numerator / denominator
            BigInteger li = numerator.divide(denominator);

            // Add to constant: c += y[i] * L_i(0)
            constant = constant.add(yValues.get(i).multiply(li));
        }

        return constant;
    }
}
