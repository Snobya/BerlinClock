package com.company.clock;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BerlinClockTest {

    private BerlinClock berlinClock;

    @Before
    public void setup() {
        berlinClock = new BerlinClock();
    }

    @Test
    public void testTwentyFourZeroZero() {
        String s = "24:00:00";
        berlinClock.setTime(s);
        String g = "Y\nRRRR\nRRRR\nOOOOOOOOOOO\nOOOO\n";
        Assert.assertTrue(
                "expected: " + g + " actual: " + berlinClock.getTime(),
                berlinClock.getTime().equals(g)
        );
    }

    @Test
    public void testTwentyThreeFiftyNineFiftyNine() {
        String s = "23:59:59";
        berlinClock.setTime(s);
        String g = "O\nRRRR\nRRRO\nYYRYYRYYRYY\nYYYY\n";
        Assert.assertTrue(
                "expected: " + g + " actual: " + berlinClock.getTime(),
                berlinClock.getTime().equals(g)
        );
    }

    @Test
    public void testThirteenSeventeenOne() {
        String s = "13:17:01";
        berlinClock.setTime(s);
        String g = "O\nRROO\nRRRO\nYYROOOOOOOO\nYYOO\n";
        Assert.assertTrue(
                "expected: " + g + " actual: " + berlinClock.getTime(),
                berlinClock.getTime().equals(g)
        );
    }

    @Test
    public void testZeroZeroZero() {
        String s = "00:00:00";
        berlinClock.setTime(s);
        String g = "Y\nOOOO\nOOOO\nOOOOOOOOOOO\nOOOO\n";
        Assert.assertTrue(
                "expected: " + g + " actual: " + berlinClock.getTime(),
                berlinClock.getTime().equals(g)
        );
    }

    @Test(expected=IllegalArgumentException.class)
    public void testNegativeSeconds() {
        berlinClock.setTime("11:22:-33");
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSixtySeconds() {
        berlinClock.setTime("11:22:60");
    }

    @Test(expected=IllegalArgumentException.class)
    public void testNegativeMinutes() {
        berlinClock.setTime("11:-22:33");
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSixtyMinutes() {
        berlinClock.setTime("11:60:33");
    }

    @Test(expected=IllegalArgumentException.class)
    public void testNegativeHours() {
        berlinClock.setTime("-11:22:33");
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testTwentyFiveHours() {
        berlinClock.setTime("25:22:33");
    }

    @Test
    public void testSecondsEven() {
        String s = "11:22:00";
        berlinClock.setTime(s);
        String g = "Y\n";
        Assert.assertTrue(
                "expected: " + g + " actual: " + berlinClock.getSeconds(),
                berlinClock.getSeconds().equals(g)
        );
    }

    @Test
    public void testSecondsOdd() {
        String s = "11:22:01";
        berlinClock.setTime(s);
        String g = "O\n";
        Assert.assertTrue(
                "expected: " + g + " actual: " + berlinClock.getSeconds(),
                berlinClock.getSeconds().equals(g)
        );
    }

    @Test
    public void testZeroMinutes() {
        String s = "00:00:00";
        berlinClock.setTime(s);
        String g = "OOOOOOOOOOO\nOOOO\n";
        Assert.assertTrue(
                "expected: " + g + " actual: " + berlinClock.getMinutes(),
                berlinClock.getMinutes().equals(g)
        );
    }

    @Test
    public void testFiftyNineMinutes() {
        String s = "00:59:00";
        berlinClock.setTime(s);
        String g = "YYRYYRYYRYY\nYYYY\n";
        Assert.assertTrue(
                "expected: " + g + " actual: " + berlinClock.getMinutes(),
                berlinClock.getMinutes().equals(g)
        );
    }

    @Test
    public void testZeroHours() {
        String s = "00:00:00";
        berlinClock.setTime(s);
        String g = "OOOO\nOOOO\n";
        Assert.assertTrue(
                "expected: " + g + " actual: " + berlinClock.getHours(),
                berlinClock.getHours().equals(g)
        );
    }

    @Test
    public void testTwentyFourHours() {
        String s = "24:00:00";
        berlinClock.setTime(s);
        String g = "RRRR\nRRRR\n";
        Assert.assertTrue(
                "expected: " + g + " actual: " + berlinClock.getHours(),
                berlinClock.getHours().equals(g)
        );
    }
}
