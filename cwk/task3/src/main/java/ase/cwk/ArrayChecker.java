package ase.cwk;

/**
 * Class for COMP5911M Coursework, Part 3.
 *
 * @author Nick Efford
 */
public class ArrayChecker {
  //the orginal method we want to refactor
  public boolean check(double[] expected, double[] actual, double maxValue, double delta) {

    // Clip 'too large' values
    for (int i = 0; i < actual.length; ++i) {
      if (actual[i] > maxValue) {
        actual[i] = maxValue;
      }
    }

    // Check for length differences
    if (actual.length != expected.length) {
      return false;
    }

    // Check that each entry is within the expected +/- delta
    for (int i = 0; i < actual.length; ++i) {
      if (Math.abs(expected[i] - actual[i]) > delta) {
        return false;
      }
    }

    return true;
  }

  //our updated method in construction
  public boolean newCheck(double[] expected, double[] actual, double maxValue, double delta) {
    return false;
  }
}
