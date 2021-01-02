package ase.rental;

public abstract class Price {
  public abstract int getPriceCode();

  public abstract int getCharge(int daysRented);

  public int getFrequentRenterPoints(int daysRented) {
    return 1;
  }
}
