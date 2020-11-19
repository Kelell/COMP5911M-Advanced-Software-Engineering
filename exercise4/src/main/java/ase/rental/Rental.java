package ase.rental;

public class Rental {
  private final Car car;
  private final int daysRented;

  public Rental(Car car, int daysRented) {
    this.car = car;
    this.daysRented = daysRented;
  }

  public Car getCar() {
    return car;
  }

  public int getDaysRented() {
    return daysRented;
  }

  public int getFrequentRenterPoints() {
    return car.getFrequentRenterPoints(daysRented);
  }

  public int getCharge() {
  return car.getCharge(daysRented);
}
}
