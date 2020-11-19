package ase.cwk;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Tests for COMP5911M Coursework 1, Part 3.
 *
 * @author Nick Efford
 */
public class ArrayCheckerTest {
  @Test
  public void testCheck() {
    ArrayChecker checker = new ArrayChecker();
    double[] expected = new double[] {10.0, 50.0, 30.0, 98.0};
    double maxValue = 100.0;
    double delta = 5.0;

    double[] actual = new double[] {12.5, 54.9, 25.4, 110.0};
    assertTrue(checker.check(expected, actual, maxValue, delta));

    actual = new double[] {12.5, 55.1, 25.4, 98.0};
    assertFalse(checker.check(expected, actual, maxValue, delta));

    actual = new double[] {10.0, 50.0, 30.0};
    assertFalse(checker.check(expected, actual, maxValue, delta));
  }
}
