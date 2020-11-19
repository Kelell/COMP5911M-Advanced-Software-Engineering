package ase.rental;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

class RentalTest {
  @Test
  void creation() {
    Car c = new Car("Ford Focus", Car.STANDARD);
    Rental r = new Rental(c, 3);
    assertThat(r.getCar(), sameInstance(c));
    assertThat(r.getDaysRented(), is(3));
  }
}
