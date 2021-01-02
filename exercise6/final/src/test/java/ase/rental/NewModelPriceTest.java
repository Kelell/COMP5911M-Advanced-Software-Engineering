package ase.rental;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NewModelPriceTest {
  private Price price;

  @BeforeEach
  void setUp() {
    price = new NewModelPrice();
  }

  @Test
  void priceCode() {
    assertThat(price.getPriceCode(), is(Car.NEW_MODEL));
  }

  @Test
  void chargeOneDay() {
    assertThat(price.getCharge(1), is(40));
  }

  @Test
  void chargeTwoDays() {
    assertThat(price.getCharge(2), is(80));
  }

  @Test
  void renterPointsOneDay() {
    assertThat(price.getFrequentRenterPoints(1), is(1));
  }

  @Test
  void renterPointsThreeDays() {
    assertThat(price.getFrequentRenterPoints(3), is(2));
  }
}
