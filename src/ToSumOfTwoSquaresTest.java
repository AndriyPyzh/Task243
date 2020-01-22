import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.*;

class ToToSumOfTwoSquaresTest {

    @Test
    void getSumOfTwoSquares() {

        for (int m = 2; m < 100; m++) {

            ArrayList<List<Integer>> expected = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j <= m; j++) {
                    if (i * i + j * j == m && i <= j) {
                        expected.add(Arrays.asList(i, j));
                    }
                }
            }

            Assert.assertEquals(expected, ToSumOfTwoSquares.findSumOfTwoSquares(m));
        }

    }

    @Test
    void existSumOfTwoSquares() {
        ArrayList<Boolean> expected = new ArrayList<>(Arrays.asList(new Boolean[200]));

        Collections.fill(expected, false);

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (i * i + j * j < 200) {
                    expected.set(i * i + j * j, true);
                }
            }
        }

        ArrayList<Boolean> actual = new ArrayList<>();

        for (int i = 0; i < 200; i++) {
            actual.add(ToSumOfTwoSquares.existSumOfTwoSquares(i));
        }

        Assert.assertEquals(expected, actual);
    }

}