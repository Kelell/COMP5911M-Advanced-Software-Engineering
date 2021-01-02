package ase.rental;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RentalTest {
  private Car car, luxCar, newCar;
  private Rental rental, luxRental, newRental;

  @BeforeEach
  void setUp() {
    car = new Car("Ford Focus", Car.STANDARD);
    luxCar = new Car("Porsche 911", Car.LUXURY);
    newCar = new Car("Renault Koleos", Car.NEW_MODEL);
    rental = new Rental(car, 2);
    luxRental = new Rental(luxCar, 2);
    newRental = new Rental(newCar, 2);
  }

  @Test
  void creation() {
    assertThat(rental.getCar(), sameInstance(car));
    assertThat(rental.getDaysRented(), is(2));
  }

  @Test
  void standardCharge() {
    assertThat(rental.getCharge(), is(60));
  }

  @Test
  void luxuryCharge() {
    assertThat(luxRental.getCharge(), is(100));
  }

  @Test
  void newModelCharge() {
    assertThat(newRental.getCharge(), is(80));
  }

  @Test
  void standardRenterPoints() {
    assertThat(rental.getFrequentRenterPoints(), is(1));
  }

  @Test
  void luxuryRenterPoints() {
    assertThat(luxRental.getFrequentRenterPoints(), is(1));
  }

  @Test
  void newShortRenterPoints() {
    assertThat(newRental.getFrequentRenterPoints(), is(1));
  }

  @Test
  void newLongRenterPoints() {
    Rental longRental = new Rental(newCar, 3);
    assertThat(longRental.getFrequentRenterPoints(), is(2));
  }

  @Test
  void standardLongRenterPoints() {
    Rental longRental = new Rental(car, 3);
    assertThat(longRental.getFrequentRenterPoints(), is(1));
  }

  @Test
  void luxuryLongRenterPoints() {
    Rental longRental = new Rental(luxCar, 3);
    assertThat(longRental.getFrequentRenterPoints(), is(1));
  }
}
