package ase.rental;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {
  private Car car, luxCar, newCar;

  @BeforeEach
  void setUp() {
    car = new Car("Ford Focus", Car.STANDARD);
    luxCar = new Car("Porsche 911", Car.LUXURY);
    newCar = new Car("Renault Koleos", Car.NEW_MODEL);
  }

  @Test
  void creation() {
    assertThat(car.getModel(), is("Ford Focus"));
    assertThat(car.getPriceCode(), is(Car.STANDARD));
  }

  @Test
  void changePriceCode() {
    car.setPriceCode(Car.NEW_MODEL);
    assertThat(car.getPriceCode(), is(Car.NEW_MODEL));
  }

  @Test
  void standardCharge() {
    assertThat(car.getCharge(2), is(60));
  }

  @Test
  void luxuryCharge() {
    assertThat(luxCar.getCharge(2), is(100));
  }

  @Test
  void newModelCharge() {
    assertThat(newCar.getCharge(2), is(80));
  }

  @Test
  void standardRenterPoints() {
    assertThat(car.getFrequentRenterPoints(2), is(1));
  }

  @Test
  void luxuryRenterPoints() {
    assertThat(luxCar.getFrequentRenterPoints(2), is(1));
  }

  @Test
  void newShortRenterPoints() {
    assertThat(newCar.getFrequentRenterPoints(2), is(1));
  }

  @Test
  void newLongRenterPoints() {
    assertThat(newCar.getFrequentRenterPoints(3), is(2));
  }

  @Test
  void standardLongRenterPoints() {
    assertThat(car.getFrequentRenterPoints(3), is(1));
  }

  @Test
  void luxuryLongRenterPoints() {
    assertThat(luxCar.getFrequentRenterPoints(3), is(1));
  }
}
