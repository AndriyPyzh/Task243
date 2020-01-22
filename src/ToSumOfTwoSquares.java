import java.util.*;
import java.util.List;

import java.util.function.Supplier;
import java.util.logging.Logger;

public class ToSumOfTwoSquares {

    private static Logger log = Logger.getLogger(ToSumOfTwoSquares.class.getName());

    public static void main(String... args) {

        int n = 1885;

        log.info(Boolean.toString(existSumOfTwoSquares(n)));
        log.info(findSumOfTwoSquares(n).toString());

    }


    public static List<List<Integer>> findSumOfTwoSquares(int m) {
        ArrayList<List<Integer>> pairs = new ArrayList<>();
        for (int i = 0; i * i < m; i++) {
            for (int j = i; j * j <= m - i * i; j++) {
                if (i * i + j * j == m) {
                    pairs.add(Arrays.asList(i,j));
                }
            }
        }
        return pairs;
    }


    public static boolean existSumOfTwoSquares(int m) {
        List<Integer> factors = factorizeNumber(m);

        Set<Integer> uniqueFactors = new HashSet<Integer>(factors);

        for (Integer i : uniqueFactors) {
            if (i % 4 == 3 && factors.stream()
                              .filter(x -> x.equals(i))
                              .count() % 2 != 0) {

                return false;
            }
        }
        return true;
    }


    public static List<Integer> factorizeNumber(int number) {
        List<Integer> factors = new ArrayList<>();
        int i = 2;
        while (i <= number) {
            if (number % i == 0) {
                factors.add(i);
                number /= i;
            } else {
                i++;
            }
        }
        return factors;
    }



}

