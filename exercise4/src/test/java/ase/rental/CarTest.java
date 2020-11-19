package ase.rental;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {
  private Car car;

  @BeforeEach
  void setUp() {
    car = new Car("Ford Focus", Car.STANDARD);
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
}
