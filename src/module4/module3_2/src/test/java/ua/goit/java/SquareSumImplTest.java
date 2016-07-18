package module4.module3_2.src.test.java.ua.goit.java;

import module3_2.SquareSum;
import module3_2.SquareSumImpl;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquareSumImplTest {

    @Test
    public void testGetSquareSum() throws Exception {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        SquareSum squareSum = new SquareSumImpl();
        long expected = 285L;
        long actual = squareSum.getSquareSum(ints, 1);
        Assert.assertEquals(expected, actual);

        actual = squareSum.getSquareSum(ints, 12);
        Assert.assertEquals(expected, actual);

        actual = squareSum.getSquareSum(ints, 3);
        Assert.assertEquals(expected, actual);

        expected = 0L;
        actual = squareSum.getSquareSum(ints, 0);
        Assert.assertEquals(expected, actual);

        actual = squareSum.getSquareSum(ints, -15);
        Assert.assertEquals(expected, actual);

        ints = new int[0];
        actual = squareSum.getSquareSum(ints, 2);
        Assert.assertEquals(expected, actual);

        ints = new int[200_000_000];
        expected = 0L;
        for (int i = 1; i < ints.length; i++) {
            expected += ints[i] * ints[i];
        }
        actual = squareSum.getSquareSum(ints, 6);
        Assert.assertEquals(expected, actual);
    }
}