package ase.rental;

public class NewModelPrice extends Price {
  @Override
  public int getPriceCode() {
    return Car.NEW_MODEL;
  }

  @Override
  public int getCharge(int daysRented) {
    return 40 * daysRented;
  }

  @Override
  public int getFrequentRenterPoints(int daysRented) {
    if (daysRented >= 3) {
      return 2;
    }
    return 1;
  }
}
