package ase.cwk;

/**
 * Class for COMP5911M Coursework, Part 3.
 *
 * @author Nick Efford
 */
public class ArrayChecker {

  public boolean newCheck(double[] expected, double[] actual, double maxValue, double delta) {

    //singular array  sweep
    for (int i = 0; i < actual.length; ++i) {
      // Clip 'too large' values
      if (actual[i] > maxValue) {
        actual[i] = maxValue;
      }
      // Check that each entry is within the expected +/- delta
      if (Math.abs(expected[i] - actual[i]) > delta) {
        return false;
      }
    }
    // Check for length differences
    if (actual.length != expected.length) {
      return false;
    }
    return true;
  }
}
