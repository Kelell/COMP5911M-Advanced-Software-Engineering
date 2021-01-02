package ase.rental;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {
  private Car car, luxCar, newCar;
  private Customer customer;

  @BeforeEach
  void setUp() {
    car = new Car("Ford Focus", Car.STANDARD);
    luxCar = new Car("Porsche 911", Car.LUXURY);
    newCar = new Car("Renault Koleos", Car.NEW_MODEL);
    customer = new Customer("John Smith");
  }

  @Test
  void creation() {
    assertThat(customer.getName(), is("John Smith"));
    String stmt = customer.statement();
    assertThat(stmt, containsString("Rental record for John Smith:"));
    assertThat(stmt, containsString("Amount owed is £0"));
    assertThat(stmt, containsString("You earned 0 frequent renter points"));
  }

  @Test
  void addRental() {
    customer.addRental(new Rental(car, 3));
    String stmt = customer.statement();
    assertThat(stmt, containsString("Ford Focus: 3 days, £90"));
    assertThat(stmt, containsString("Amount owed is £90"));
    assertThat(stmt, containsString("You earned 1 frequent renter points"));
  }

  @Test
  void addLuxuryRental() {
    customer.addRental(new Rental(luxCar, 3));
    String stmt = customer.statement();
    assertThat(stmt, containsString("Porsche 911: 3 days, £150"));
    assertThat(stmt, containsString("Amount owed is £150"));
    assertThat(stmt, containsString("You earned 1 frequent renter points"));
  }

  @Test
  void addShortNewModelRental() {
    customer.addRental(new Rental(newCar, 2));
    String stmt = customer.statement();
    assertThat(stmt, containsString("Renault Koleos: 2 days, £80"));
    assertThat(stmt, containsString("Amount owed is £80"));
    assertThat(stmt, containsString("You earned 1 frequent renter points"));
  }

  @Test
  void addLongNewModelRental() {
    customer.addRental(new Rental(newCar, 3));
    String stmt = customer.statement();
    assertThat(stmt, containsString("Renault Koleos: 3 days, £120"));
    assertThat(stmt, containsString("Amount owed is £120"));
    assertThat(stmt, containsString("You earned 2 frequent renter points"));
  }

  @Test
  void addTwoRentals() {
    customer.addRental(new Rental(car, 3));
    customer.addRental(new Rental(luxCar, 2));
    String stmt = customer.statement();
    assertThat(stmt, containsString("Amount owed is £190"));
    assertThat(stmt, containsString("You earned 2 frequent renter points"));
  }
}
